/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3946.UltimateAscent.RobotMap;

/**
 *
 * @author Makaylah
 */
public class FrisbeeLoader extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Relay relay = new Relay(RobotMap.frisbeeLoader);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(Relay.Value value) {
        relay.set(value);
        if(value == Relay.Value.kForward) {
            SmartDashboard.putString("Loader", "Forward");
        } else if(value == Relay.Value.kReverse) {
            SmartDashboard.putString("Loader", "Reverse");
        } else {
            SmartDashboard.putString("Loader", "Off");
        }
    }
    
    public FrisbeeLoader() {
        super();
        LiveWindow.addActuator("FrisbeeLoader", "Spike", relay);
        System.out.println(this.getClass().getName()+" Initialized");
    }
}
