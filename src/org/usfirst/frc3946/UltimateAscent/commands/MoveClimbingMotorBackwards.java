/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author 10374778
 */
public class MoveClimbingMotorBackwards extends CommandBase {
    
    public MoveClimbingMotorBackwards() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (climbingMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
         System.out.println("MoveClimbingMotorBackwards");
    }

    protected void execute() {
        climbingMotor.set(Relay.Value.kReverse);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (climbingMotor.getAmps() > 17){
            return true;
        }
        else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        climbingMotor.set(Relay.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        climbingMotor.set(Relay.Value.kOff);
    }
}
