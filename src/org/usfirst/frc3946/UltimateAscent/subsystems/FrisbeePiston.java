/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc3946.UltimateAscent.RobotMap;

/**
 *
 * @author AJ
 */
public class FrisbeePiston extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private DoubleSolenoid piston = new DoubleSolenoid(RobotMap.firePistonExtend, RobotMap.firePistonRetract);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void extend(){
        piston.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void retract(){
        piston.set(DoubleSolenoid.Value.kForward);
    }
     
    public void set(DoubleSolenoid.Value value) {
        piston.set(value);
    }
    
    public FrisbeePiston() {
        super();
        LiveWindow.addActuator("FrisbeePiston", "Piston", piston);
        System.out.println(this.getClass().getName()+" Initialized");
    }
}
