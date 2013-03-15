/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

import edu.wpi.first.wpilibj.Timer;
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
            
    private int center;
    private int distance;
    private int errorAccum = 0;
    
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
        
        driveTrain.tankDrive(left, right);
        currentTime = Timer.getFPGATimestamp();

        center = threadedberryPi.getOffset();
        
        robotIsCentered = false;
        robotInPosition = false;
        if (center >= 15) { //Turning
            driveTrain.tankDrive(-1, 1);
            left = -1;
            right = 1;
        } else if (center <= -25) {
            driveTrain.tankDrive(1, -1);
            left = 1;
            right = -1;
        } else {
            robotIsCentered = true;
            driveTrain.tankDrive(0, 0);
            left = 0;
            right = 0;
        }

        if (robotIsCentered == true) {
            if (distance >= 22500) { //Distance
                driveTrain.tankDrive(1, 1);
                left = 1;
                right = 1;
            } else if (distance <= 21500) {
                driveTrain.tankDrive(-1, -1);
                left = -1;
                right = -1;
            } else {
                driveTrain.tankDrive(0, 0);
                left = 0;
                right = 0;
                robotInPosition = true;
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
