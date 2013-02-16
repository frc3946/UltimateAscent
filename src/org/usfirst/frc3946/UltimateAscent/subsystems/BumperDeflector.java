/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3946.UltimateAscent.RobotMap;

/**
 *
 * @author 10482352
 */
public class BumperDeflector extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
      private Relay deflector = new Relay(RobotMap.deflector);
      
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void extend() {
        deflector.set(Relay.Value.kForward);
        SmartDashboard.putString("Loader", "Forward");
    }
    
    public void retract() {
        deflector.set(Relay.Value.kReverse);
        SmartDashboard.putString("Loader", "Reverse");
    }
    
    public void set(Relay.Value value) {
        deflector.set(value);
        if(value == Relay.Value.kForward) {
            SmartDashboard.putString("Loader", "Forward");
        } else if(value == Relay.Value.kReverse) {
           SmartDashboard.putString("Loader", "Reverse");
        } else {
            SmartDashboard.putString("Loader", "Off");
        }
    }
}
