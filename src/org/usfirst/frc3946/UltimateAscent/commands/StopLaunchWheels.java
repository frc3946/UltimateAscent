/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

/**
 *
 * @author Gustave Michel
 */
public class StopLaunchWheels extends CommandBase {
    
    int timeout;
    public StopLaunchWheels(int newTimeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(frisbeeWheels);
        timeout = newTimeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        frisbeeWheels.set(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("StopLaunchWheels interrupted");
    }
}
