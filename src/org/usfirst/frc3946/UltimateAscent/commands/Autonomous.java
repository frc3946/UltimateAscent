/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Gustave Michel
 */
public class Autonomous extends CommandGroup {
    
    public Autonomous() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        
        //shoot four frisbee with a delay in between
        double frisbeeShotDelay = 1.0;
        
       
        addSequential(new LaunchFrisbee());
        addSequential(new Delay(frisbeeShotDelay));
        
        addSequential(new LaunchFrisbee());
        addSequential(new Delay(frisbeeShotDelay));
        
        addSequential(new LaunchFrisbee());
        addSequential(new Delay(frisbeeShotDelay));
        
        addSequential(new LaunchFrisbee());
        addSequential(new Delay(frisbeeShotDelay));
        
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
