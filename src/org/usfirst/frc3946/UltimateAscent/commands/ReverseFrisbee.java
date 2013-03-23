/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Jeff
 */
public class ReverseFrisbee extends CommandBase {
    
    public ReverseFrisbee() {
        requires(frisbeeLoader);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        frisbeeLoader.set(Relay.Value.kForward);
        SmartDashboard.putData("Unloading:", frisbeeLoader.getCurrentCommand());
        setTimeout(.2);
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
        frisbeeLoader.set(Relay.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
