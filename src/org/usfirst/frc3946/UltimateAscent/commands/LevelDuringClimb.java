/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author 10374778
 */
public class LevelDuringClimb extends CommandBase {
    double currentTime;
    double lastFail = 0;
    boolean balanced = false;
            
    public LevelDuringClimb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (climbingMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("LevelDuringClimb");
        climbingMotor.setSetpoint(0.0);
        climbingMotor.enable();
        setTimeout (2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        currentTime = Timer.getFPGATimestamp();
        
        if (climbingMotor.AmIBalanced() == false) {
            lastFail = currentTime;
            balanced = false;
        } else {
            if (currentTime - lastFail > 2) {
                balanced = true;
            }
        }
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        return balanced;
    }

    // Called once after isFinished returns true
    protected void end() {
        climbingMotor.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
         System.out.println("Climbing interrupted");
    }
}
