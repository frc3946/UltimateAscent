/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

/**
 *
 * @author 10374778
 */
public class LevelDuringClimb extends CommandBase {
    
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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        return climbingMotor.AmIBalanced();
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
