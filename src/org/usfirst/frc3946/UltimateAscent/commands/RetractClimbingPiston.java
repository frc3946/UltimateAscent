/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

/**
 *
 * @author 10374778
 */
public class RetractClimbingPiston extends CommandBase {
    
    public RetractClimbingPiston() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (climbingPiston);
        requires (climbingMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       setTimeout(5);
       climbingPiston.retract();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (climbingMotor.IsTimeToAbort() == true){
            climbingPiston.stop();
            return true;
        }
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
