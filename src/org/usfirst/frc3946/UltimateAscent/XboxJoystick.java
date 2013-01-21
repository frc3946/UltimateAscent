/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.parsing.IInputOutput;

/**
 * Drop in replacement for Joystick using XBOX USB Controller
 * @author gixxy
 */
public class XboxJoystick extends GenericHID {
    
    private DriverStation m_ds;
    private final int m_port;
    
    /**
     * Represents an analog axis on a joystick.
     */
    public static class AxisType {
        
        /**
         * The integer value representing this enumeration
         */
        public final int value;
        static final int kLeftX_val = 1;
        static final int kLeftY_val = 2;
        static final int kTrigger_val = 3;
        static final int kRightX_val = 4;
        static final int kRightY_val = 5;
        static final int kDLeftRight_val = 6;
        
        private AxisType(int value) {
            this.value = value;
        }
        
        /**
         * Axis: Left X
         */
        public static final AxisType kLeftX = new AxisType(kLeftX_val);
        
        /**
         * Axis: Left Y
         */
        public static final AxisType kLeftY = new AxisType(kLeftY_val);
        
        /**
         * Axis: Triggers
         */
        public static final AxisType kTrigger = new AxisType(kTrigger_val);
        
        /**
         * Axis: Right X
         */
        public static final AxisType kRightX = new AxisType(kRightX_val);
        
        /**
         * Axis: Right Y
         */
        public static final AxisType kRightY = new AxisType(kRightY_val);
        
        /**
         * Axis: D-Pad Left-Right
         */
        public static final AxisType kDLeftRight = new AxisType(kDLeftRight_val);
    }
    
    /**
     * Represents a digital button on a joystick.
     */
    public static class ButtonType {
        
        /**
         * The integer value representing this enumeration
         */
        public final int value;
        static final int kA_val = 1;
        static final int kB_val = 2;
        static final int kX_val = 3;
        static final int kY_val = 4;
        static final int kL_val = 5;
        static final int kR_val = 6;
        static final int kBack_val = 7;
        static final int kSelect_val = 8;
        static final int kXStick_val = 9;
        static final int kYStick_val = 10;
        
        private ButtonType(int value) {
            this.value = value;
        }
        
        /**
         * Button: X-Joystick
         */
        public static final ButtonType kXStick = new ButtonType(kXStick_val);
        
        /**
         * Button: Y-Joystick
         */
        public static final ButtonType kYStick = new ButtonType(kYStick_val);
        
        /**
         * Button: X
         */
        public static final ButtonType kX = new ButtonType(kX_val);
        
        /**
         * Button: Y
         */
        public static final ButtonType kY = new ButtonType(kY_val);
        
        /**
         * Button: A
         */
        public static final ButtonType kA = new ButtonType(kA_val);
        
        /**
         * Button: B
         */
        public static final ButtonType kB = new ButtonType(kB_val);
        
        /**
         * Button: R1
         */
        public static final ButtonType kR = new ButtonType(kR_val);
        
        /**
         * Button: L1
         */
        public static final ButtonType kL = new ButtonType(kL_val);
        
        /**
         * Button: Select
         */
        public static final ButtonType kSelect = new ButtonType(kSelect_val);
        
        /**
         * Button: Start
         */
        public static final ButtonType kBack = new ButtonType(kBack_val);
    }
    
    
    /**
     * Constructor
     * @param port USB Port on DriverStation
     */
    public XboxJoystick(int port) {
        m_port = port;
        m_ds = DriverStation.getInstance();
    }

    public double getX(Hand hand) {
        return 0;
    }

    public double getY(Hand hand) {
        return 0;
    }

    public double getZ(Hand hand) {
        return 0;
    }

    public double getTwist() {
        return 0;
    }

    public double getThrottle() {
        return 0;
    }

    public double getRawAxis(int axis) {
        return m_ds.getStickAxis(m_port, axis);
    }

    public boolean getTrigger(Hand hand) {
        return false;
    }

    public boolean getTop(Hand hand) {
        return false;
    }

    public boolean getBumper(Hand hand) {
        return false;
    }

    public boolean getRawButton(int button) {
        return ((0x1 << (button - 1)) & m_ds.getStickButtons(m_port)) != 0;
    }
}
