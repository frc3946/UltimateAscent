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
public class TopClimbingPistons extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    //TODO Rewrite to use two seprate controls.
    private DoubleSolenoid piston = new DoubleSolenoid(RobotMap.topPistonRetract, RobotMap.topPistonExtend);
    
               
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
        piston.set(value);
        if(value == DoubleSolenoid.Value.kForward) {
            SmartDashboard.putString("Loader", "Extend");
        } else if(value == DoubleSolenoid.Value.kReverse) {
            SmartDashboard.putString("Loader", "Retract");
        } else {
            SmartDashboard.putString("Loader", "Off");
        }
    }
    
    public TopClimbingPistons() {
        super();
        LiveWindow.addActuator("ClimbPiston", "ClimbPiston", piston);
        System.out.println(this.getClass().getName()+" Initialized");
    }
}
