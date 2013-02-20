/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3946.UltimateAscent.ThreadedPi;

/**
 *
 * @author Gustave Michel
 */
public class ThreadedberryPi extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    ThreadedPi raspberryPi = new ThreadedPi();
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    /**
     * Start getting Data from Pi
     */
    public void start() {
        raspberryPi.start();
    }
    /**
     * Stop getting Data from Pi
     */
    public void stop() {
        raspberryPi.stop();
    }
    
    /**
     * Get Offset from center from Pi
     * @return Offset from Center
     */
    public int getOffset() {
       return raspberryPi.getOffset();
    }
    /**
     * Get Distance from goal from Pi
     * @return Distance from goal
     */
    public int getDistance() {
       return raspberryPi.getDistance();
    }
    /**
     * Get Timestamp from last received Data
     * @return Timestamp from Data
     */
    public double getTime() {
       return raspberryPi.getTime();
    }
}
