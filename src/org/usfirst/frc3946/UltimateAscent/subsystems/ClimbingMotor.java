/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3946.UltimateAscent.RobotMap;

/**
 *
 * @author Gustave Michel
 */
public class ClimbingMotor extends PIDSubsystem {

    private static final double Kp = 1.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;

    // Initialize your subsystem here
    Victor motor = new Victor(RobotMap.climbingMotor);
    ADXL345_I2C balancer;
    AnalogChannel currentSensor = new AnalogChannel(RobotMap.currentSensor);
    
    public ClimbingMotor() {
        super("ClimbingMotor", Kp, Ki, Kd);
        balancer = new ADXL345_I2C(1,ADXL345_I2C.DataFormat_Range.k16G);
        LiveWindow.addActuator("ClimbingMotor", "Motor", motor);
        LiveWindow.addSensor("ClimbingMotor", "CurrentSensor", currentSensor);
        
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        SmartDashboard.putNumber("Balancer", getYAccel());
        SmartDashboard.putNumber("Current", currentSensor.getVoltage());
        return getYAccel();
    }
    
    protected void usePIDOutput(double output) {
    
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        double amps = getAmps();
        if(amps > 25){
            motor.set(0);
            return ;
        }
        if(output > 0.1){
            motor.set(1);
        }
        else if(output < -0.1){
            motor.set(-1);
        }
        else{
            motor.set(0);
        }
        
        
    }
    
    public void set(Relay.Value value) {
        if(value == Relay.Value.kForward) {
            motor.set(1);
        } else if(value == Relay.Value.kReverse) {
            motor.set(-1);
        } else {
            motor.set(0);
        }
    }
    
    public boolean AmIBalanced(){
        double YAxis = balancer.getAcceleration(ADXL345_I2C.Axes.kY);
        if (YAxis < 0.1 && YAxis > -0.1){
           return true;}
        else {
            return false;
        }}
    
    public boolean IsTimeToAbort(){
        double YAxis = balancer.getAcceleration(ADXL345_I2C.Axes.kY);
        if (YAxis < 0.6 && YAxis > -0.6){
           return false;
        }
        else {
            return true;
        }
    }
    
    public double getAmps(){
        return currentSensor.getVoltage()*15.7;
    }
    
       public double getYAccel(){
           
        ADXL345_I2C.AllAxes allAxes =   balancer.getAccelerations();
        
           
        return allAxes.YAxis;
    }
    
}
