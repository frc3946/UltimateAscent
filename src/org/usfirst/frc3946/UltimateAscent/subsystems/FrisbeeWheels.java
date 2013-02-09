/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3946.UltimateAscent.RobotMap;

/**
 *
 * @author 10482352
 */
public class FrisbeeWheels extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Jaguar jaguar1 = new Jaguar(RobotMap.frisbeeJaguar1);
    public Jaguar jaguar2 = new Jaguar(RobotMap.frisbeeJaguar2);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
