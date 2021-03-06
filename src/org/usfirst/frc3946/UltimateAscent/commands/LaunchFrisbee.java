/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author AJ
 */
public class LaunchFrisbee extends CommandGroup {
    
    public LaunchFrisbee() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.'
        System.out.println("LaunchFrisbee");
        addSequential(new StartLaunchWheels());
        //for(int i = 0; i < 3; i++) {
        addSequential(new FirePiston());
        addSequential(new ReverseFrisbee());
        addSequential(new IncrementFrisbee());
        //}
        //addSequential(new LoadFrisbee(), 1.5);
        //addSequential(new FirePiston());
        addParallel(new StopLaunchWheels(5));
        //addSequential(new LoadFrisbee(), 1.5);
    }
}
