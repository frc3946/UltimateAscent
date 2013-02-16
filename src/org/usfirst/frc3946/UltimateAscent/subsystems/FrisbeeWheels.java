/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc3946.UltimateAscent.RobotMap;

/**
 *
 * @author Makaylah
 */
public class FrisbeeWheels extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Jaguar firstWheel = new Jaguar(RobotMap.frisbeeFirstWheel);
    public Jaguar secondWheel = new Jaguar(RobotMap.frisbeeSecondWheel);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(double firstSpeed, double secondSpeed) {
        firstWheel.set(firstSpeed);
        //secondWheel.set(-1*secondSpeed);
    }
    
    public FrisbeeWheels() {
        super();
        LiveWindow.addActuator("FrisbeeWheels", "FirstWheel", firstWheel);
        LiveWindow.addActuator("FrisbeeWheels", "SecondWheel", secondWheel);
        System.out.println(this.getClass().getName()+" Initialized");
    }
}
