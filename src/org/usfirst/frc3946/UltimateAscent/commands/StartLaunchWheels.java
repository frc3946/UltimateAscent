/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

/**
 *
 * @author 10482352
 */
public class StartLaunchWheels extends CommandBase {
    
    public StartLaunchWheels() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(frisbeeWheels);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        frisbeeWheels.set(0.4, 0.9);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        frisbeeWheels.set(0, 0);
    }
}
