/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author Gustave Michel
 */
public class LowerBumperDeflector extends CommandBase {
    
    public LowerBumperDeflector() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(deflector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(.3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        deflector.extend();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        deflector.set(Relay.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}