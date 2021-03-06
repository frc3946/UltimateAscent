/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Gustave Michel
 */
public class FirePiston extends CommandBase {
    
    public FirePiston() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//        requires(bottomClimbingPiston);
        requires(firePiston);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        setTimeout(.5);
        firePiston.extend();
        SmartDashboard.putData("Fire Piston", firePiston.getCurrentCommand());
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
        firePiston.retract();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
