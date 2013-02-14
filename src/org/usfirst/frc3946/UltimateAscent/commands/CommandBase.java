package org.usfirst.frc3946.UltimateAscent.commands;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3946.UltimateAscent.OI;
import org.usfirst.frc3946.UltimateAscent.RobotMap;
import org.usfirst.frc3946.UltimateAscent.subsystems.*;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    //public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static Compressor compressor = new Compressor();
    public static DriveTrain driveTrain = new DriveTrain();
    public static FrisbeeLoader frisbeeLoader= new FrisbeeLoader();
    public static FrisbeePiston firePiston = new FrisbeePiston();
    public static FrisbeeWheels frisbeeWheels = new FrisbeeWheels();
 
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(exampleSubsystem);
        SmartDashboard.putData(compressor);
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putData(frisbeeLoader);
        SmartDashboard.putData(firePiston);
        SmartDashboard.putData(frisbeeWheels);
        
        //SmartDashboard Buttons
        //SmartDashboard.putData("ExampleSubsystem", new ExampleSubsystem());
        //SmartDashboard.putData("TankDrive", new TankDrive());
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
