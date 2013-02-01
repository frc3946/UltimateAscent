/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc3946.UltimateAscent.RobotMap;
import org.usfirst.frc3946.UltimateAscent.commands.TankDrive;

/**
 *
 * @author Gustave Michel
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Jaguar left = new Jaguar(RobotMap.leftJaguar);
    private Jaguar right = new Jaguar(RobotMap.rightJaguar);
    private RobotDrive drive = new RobotDrive(left,right);
    
    public void tankDrive(GenericHID left, GenericHID right) {
        drive.tankDrive(left, right);
    }
    
    public void tankDrive(GenericHID stick) {
        drive.tankDrive(stick.getY(GenericHID.Hand.kLeft), stick.getY(GenericHID.Hand.kRight));
    }
    
    public void tankDrive(double left, double right) {
        drive.tankDrive(left, right);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TankDrive());
    }
    
    public DriveTrain() {
        super();
        LiveWindow.addActuator("DriveTrain", "RightWheel", right);
        LiveWindow.addActuator("DriveTrain", "LeftWheel", left);
    }
}
