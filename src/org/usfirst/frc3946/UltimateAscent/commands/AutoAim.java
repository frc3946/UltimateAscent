/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3946.UltimateAscent.subsystems.ThreadedberryPi;

/**
 *
 * @author Gustave Michel
 */
public class AutoAim extends CommandBase {

    private double currentTime = 0;
    private double previousCheckTime = 0;
    private double checkInterum = .4;
    private double previousConnectTime = 0;
    private double connectInterum = 1;
    private boolean robotIsCentered = false;
    private boolean robotIsOffset = false;
    private boolean robotInPosition = false;
    private double left = 0;
    private double right = 0;
    private double delta = 1.0;
    private double adjustedMotorSpeed = 0;
    private double timeDelta = 0;
    private double lastMotorUpdateTime = 0;
    private double lastMotorUpdateDelta = 0;
    private int center;
    private int centerDelta;
    private int centerRange = 40;
    private static final int centerMidpoint = 65;
    private static int centerAdjust = 0;
    private int distance;
    private int distanceDelta;
    private int distanceRange = 1000;
    private static final int distanceMidPoint = 22000;
    private static int distAdjust = 0;
    private int errorAccum = 0;
    public static final double maxMotorSpeed = 1;
    public static final double minMotorSpeed = .5;

    public AutoAim() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        //requires(raspberryPi);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putNumber("PiTime", threadedberryPi.getTime());
        SmartDashboard.putNumber("PiDistance", threadedberryPi.getDistance());
        SmartDashboard.putNumber("PiOffset", threadedberryPi.getOffset());
        SmartDashboard.putBoolean("PiReport", threadedberryPi.getReport());

        currentTime = threadedberryPi.getTime();
        //System.out.println(currentTime + ", " + previousCheckTime);
        timeDelta = currentTime - previousCheckTime;
        previousCheckTime = currentTime;
        lastMotorUpdateDelta = Timer.getFPGATimestamp() - lastMotorUpdateTime;

        //there is a "dead time" between .2 and .7 where the motors are stopped
        if ((lastMotorUpdateDelta < .7 && lastMotorUpdateDelta > .35)
                || timeDelta > 0.5
                || threadedberryPi.getReport() == false) {
            left = 0;
            right = 0;
            return;
        }

        //only refresh teh variable after the alive time had ended
        if (lastMotorUpdateDelta >= .3) {
            lastMotorUpdateTime = Timer.getFPGATimestamp();
            center = threadedberryPi.getOffset();
            distance = threadedberryPi.getDistance();
        }


        //center = threadedberryPi.getOffset();

        robotIsCentered = false;
        robotInPosition = false;
        centerDelta = center - (centerMidpoint - centerAdjust);
        delta = centerDelta / (centerRange*3);
        if (delta > 1.0){
            delta =1.0;
        }
        adjustedMotorSpeed = Math.max(minMotorSpeed, maxMotorSpeed * delta);

        if (centerDelta <= centerRange / 2) { //Turning
            left = -adjustedMotorSpeed;
            right = adjustedMotorSpeed;
        } else if (centerDelta >= -centerRange / 2) {
            left = adjustedMotorSpeed;
            right = -adjustedMotorSpeed;
        } else {
            robotIsCentered = true;
            left = 0;
            right = 0;
        }

        //if we are in center mode only run for a lower amount of seconds
        //if (lastMotorUpdateDelta >= .12 && robotIsCentered == false) {
          //  left = 0;
            //right = 0;
            //return;
        //}

        if (robotIsCentered == true) {

            
            distanceDelta = distance - (distanceMidPoint+distAdjust);
            delta = distanceDelta / (distanceRange*2);
            if (delta > 1.0){
                delta =1.0;
            }
            adjustedMotorSpeed = Math.max(minMotorSpeed, maxMotorSpeed * delta);
            if (distanceDelta >= distanceRange / 2) { //Turning            
                left = -adjustedMotorSpeed;
                right = -adjustedMotorSpeed;
            } else if (distanceDelta <= -distanceRange / 2) {
                left = adjustedMotorSpeed;
                right = adjustedMotorSpeed;
            } else {
                robotInPosition = true;
                left = 0;
                right = 0;
            }


        }
        if (robotInPosition == true && robotIsCentered == true) {
            SmartDashboard.putBoolean("Locked on", true);
        } else {
            SmartDashboard.putBoolean("Locked on", false);
        }

    }
    
    protected static void aimUp() {
        distAdjust += 250;
        SmartDashboard.putNumber("Distance Adjustment", distAdjust);
    }
    
    protected static void aimDown() {
        distAdjust -= 250;
        SmartDashboard.putNumber("Distance Adjustment", distAdjust);
    }
    
    protected static void aimLeft() {
        centerAdjust -= 15;
        SmartDashboard.putNumber("Windage Adjustment", centerAdjust);
    }
    
    protected static void aimRight() {
        centerAdjust += 15;
        SmartDashboard.putNumber("Windage Adjustment", centerAdjust);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        driveTrain.tankDrive(left, right);
        return robotInPosition;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        driveTrain.tankDrive(0, 0);
    }
}
