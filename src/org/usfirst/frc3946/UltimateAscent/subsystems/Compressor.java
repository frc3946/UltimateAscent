/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3946.UltimateAscent.RobotMap;
import org.usfirst.frc3946.UltimateAscent.commands.StartCompressor;

/**
 *
 * @author Gustave Michel
 */
public class Compressor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
//    private edu.wpi.first.wpilibj.Compressor compressor = new edu.wpi.first.wpilibj.Compressor(RobotMap.pressureSwitch, RobotMap.compressorRelay);
    private Relay comp = new Relay(RobotMap.compressorRelay);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new StartCompressor());
    }
    
    public void start() {
//        compressor.start();
        comp.set(Relay.Value.kForward);
    }
    
    public void stop() {
//        compressor.stop();
        comp.set(Relay.Value.kOff);
    }
    
    public Compressor() {
        super();
//        LiveWindow.addActuator("Compressor", "Compressor", compressor);
        System.out.println(this.getClass().getName()+" Initialized");
    }
}
