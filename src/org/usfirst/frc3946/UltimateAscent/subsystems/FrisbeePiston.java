/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3946.UltimateAscent.RobotMap;

/**
 *
 * @author AJ
 */
public class FrisbeePiston extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private DoubleSolenoid pistonSolenoid;
    
    public FrisbeePiston() {
        System.out.println("(LoadPiston) Starting");
        pistonSolenoid = new DoubleSolenoid(RobotMap.firePistonExtend, RobotMap.firePistonRetract);
    }
    
    public void extend(){
        System.out.println("(LoadPiston) Extend");
        pistonSolenoid.set(DoubleSolenoid.Value.kReverse);
        
    }
    
    public void retract(){
        System.out.println("(LoadPiston) Retract");
        pistonSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
