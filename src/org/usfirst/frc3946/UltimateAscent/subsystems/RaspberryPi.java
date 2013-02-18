/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3946.UltimateAscent.SocketPi;
import org.usfirst.frc3946.UltimateAscent.commands.PrintPiData;

/**
 *
 * @author Gustave Michel
 */
public class RaspberryPi extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SocketPi raspberryPi;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new PrintPiData());
    }
    public SocketPi getPi() {
        return raspberryPi;
    }
    
    public RaspberryPi() {
        super();
        raspberryPi = new SocketPi();
        System.out.println(this.getClass().getName()+" Initialized");
    }
}
