/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3946.UltimateAscent.RobotMap;

/**
 *
 * @author 10482352
 */
public class FrisbeeLoader extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Relay relay = new Relay(RobotMap.frisbeeLoader);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
}
