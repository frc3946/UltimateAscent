/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author OpalStone
 */
public class Climb extends CommandGroup {
    
    public Climb() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
//        addSequential (new ExtendTopClimbingPiston());
        addSequential (new RetractTopClimbingPiston());
        addSequential(new RetractBottomPiston());
        addSequential (new MoveClimbingMotor());
        addSequential (new ExtendBottomClimbingPiston());
//        #9 move horizontal hooks until level
        addSequential (new LevelDuringClimb());
        
        addParallel (new ExtendTopClimbingPiston());
        addSequential (new LevelDuringClimb());
        addSequential (new MoveClimbingMotorBackwards());

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
