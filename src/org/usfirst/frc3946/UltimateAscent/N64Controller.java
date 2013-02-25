/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.parsing.IInputOutput;

/**
 *
 * @author Gustave Michel
 */
public class N64Controller extends GenericHID implements IInputOutput {
    private int m_port;
    private DriverStation m_ds;
    
    public static class AxisType {
        private static final int kX_val = 1;
        private static final int kY_val = 2;
        
        public int value;
        
        private AxisType(int value) {
            this.value = value;
        }
        
        public static final AxisType kX = new AxisType(kX_val);
        public static final AxisType kY = new AxisType(kY_val);
    }
    
    public static class ButtonType {
        private static final int kA_val = 1;
        private static final int kB_val = 2;
        private static final int kStart_val = 3;
        private static final int kL_val = 4;
        private static final int kR_val = 5;
        private static final int kZ_val = 6;
        private static final int kCUp_val = 7;
        private static final int kCRight_val = 8;
        private static final int kCDown_val = 9;
        private static final int kCLeft_val = 10;
        private static final int kDUp_val = 11;
        private static final int kDRight_val = 12;
        private static final int kDDown_val = 13;
        private static final int kDLeft_val = 14;
        
        public int value;
        
        private ButtonType(int value) {
            this.value = value;
        }
        
        private static final ButtonType kA = new ButtonType(kA_val);
        private static final ButtonType kB = new ButtonType(kB_val);
        private static final ButtonType kStart = new ButtonType(kStart_val);
        private static final ButtonType kL = new ButtonType(kL_val);
        private static final ButtonType kR = new ButtonType(kR_val);
        private static final ButtonType kZ = new ButtonType(kZ_val);
        private static final ButtonType kCUp = new ButtonType(kCUp_val);
        private static final ButtonType kCRight = new ButtonType(kCRight_val);
        private static final ButtonType kCDown = new ButtonType(kCDown_val);
        private static final ButtonType kCLeft = new ButtonType(kCLeft_val);
        private static final ButtonType kDUp = new ButtonType(kDUp_val);
        private static final ButtonType kDRight = new ButtonType(kDRight_val);
        private static final ButtonType kDDown = new ButtonType(kDDown_val);
        private static final ButtonType kDLeft = new ButtonType(kDLeft_val);
        
    }
    
    public N64Controller(int port) {
        super();
        m_port = port;
        m_ds = DriverStation.getInstance();
    }

    public double getX(Hand hand) {
        return getAxis(AxisType.kX);
    }

    public double getY(Hand hand) {
        return getAxis(AxisType.kY);
    }

    public double getZ(Hand hand) {
        return 0.0;
    }

    public double getTwist() {
        return 0.0;
    }

    public double getThrottle() {
        return 0.0;
    }
    
    public double getAxis(AxisType axis) {
        return getRawAxis(axis.value);
    }
    
    public double getRawAxis(int axis) {
        return m_ds.getStickAxis(m_port, axis);
    }

    public boolean getTrigger(Hand hand) {
        return getButton(ButtonType.kZ);
    }

    public boolean getTop(Hand hand) {
        return false;
    }

    public boolean getBumper(Hand hand) {
        return false;
    }
    
    public boolean getButton(ButtonType button) {
        return getRawButton(button.value);
    }
    
    public boolean getRawButton(int button) {
        return ((0x1 << (button - 1)) & m_ds.getStickButtons(m_port)) != 0;
    }
    
}
