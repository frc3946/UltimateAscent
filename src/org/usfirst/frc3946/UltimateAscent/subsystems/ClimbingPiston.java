/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3946.UltimateAscent.RobotMap;

/**
 *
 * @author 10482352
 */
public class ClimbingPiston extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private DoubleSolenoid piston1 = new DoubleSolenoid(RobotMap.pistonRetract1, RobotMap.pistonExtend1);
    private DoubleSolenoid piston2 = new DoubleSolenoid(RobotMap.pistonRetract2, RobotMap.pistonExtend2);
               
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void extend(){
        set(DoubleSolenoid.Value.kForward);
    }
    
    public void stop(){
        set(DoubleSolenoid.Value.kOff);
    }
    
    public void retract(){
        set(DoubleSolenoid.Value.kReverse);
    }
    
    public void set(DoubleSolenoid.Value value) {
        piston1.set(value);
        piston2.set(value);
        if(value == DoubleSolenoid.Value.kForward) {
            SmartDashboard.putString("Loader", "Extend");
        } else if(value == DoubleSolenoid.Value.kReverse) {
            SmartDashboard.putString("Loader", "Retract");
        } else {
            SmartDashboard.putString("Loader", "Off");
        }
    }
    
    public ClimbingPiston() {
        super();
        LiveWindow.addActuator("ClimbPiston", "ClimbPiston", piston1);
        System.out.println(this.getClass().getName()+" Initialized");
    }
}
