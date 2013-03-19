
package org.usfirst.frc3946.UltimateAscent;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc3946.UltimateAscent.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    private XboxController xbox;
    private Joystick genius;
    
    private Button launchFrisbee;
    private Button loadFrisbee;
    private Button firePiston;
    private Button TopClimbingPiston;
    private Button BottomClimbingPiston;
//    private Button Climb;
    private Button pitchFore;
    private Button pitchAft;
    private Button StopMotors;
    private Button AutoAim;
    
    private Button adjustUp;
    private Button adjustLeft;
    private Button adjustRight;
    private Button adjustDown;
    
    
    public OI() {
        xbox = new XboxController(RobotMap.xboxController);
        genius = new Joystick(RobotMap.leftJoystick);
        
        firePiston = new JoystickButton(xbox, RobotMap.firePiston);
        loadFrisbee = new JoystickButton(xbox, RobotMap.loadFrisbee);
        launchFrisbee = new JoystickButton(xbox, RobotMap.launchFrisbee);
        TopClimbingPiston = new JoystickButton (xbox, RobotMap.TopClimbingPiston);
        BottomClimbingPiston = new JoystickButton (xbox, RobotMap.BottomClimbingPiston);
//        Climb = new JoystickButton(xbox, RobotMap.Climb);
        pitchFore = new JoystickButton(xbox, RobotMap.pitchFore);
        pitchAft = new JoystickButton(xbox, RobotMap.pitchAft);
        StopMotors = new JoystickButton(xbox, RobotMap.StopMotors);
        AutoAim = new JoystickButton(xbox, RobotMap.AutoAim);
        
        adjustUp = new JoystickButton(genius, RobotMap.adjustUp);
        adjustLeft = new JoystickButton(genius, RobotMap.adjustLeft);
        adjustRight = new JoystickButton(genius, RobotMap.adjustRight);
        adjustDown = new JoystickButton(genius, RobotMap.adjustDown);
        
        
        AutoAim.whileHeld(new AutoAim());
        loadFrisbee.whileHeld(new LaunchFrisbee());
        launchFrisbee.whenPressed(new LoadFrisbee());
        StopMotors.whenPressed(new StopLaunchWheels(0));
        loadFrisbee.whileHeld(new LoadFrisbee());
        firePiston.whenPressed(new FirePiston());
        TopClimbingPiston.whileHeld(new ExtendTopClimbingPiston());
        TopClimbingPiston.whenReleased(new RetractTopClimbingPiston());
        BottomClimbingPiston.whileHeld(new ExtendBottomClimbingPiston());
        BottomClimbingPiston.whenReleased(new RetractBottomPiston());
//        Climb.whenPressed(new LevelDuringClimb());
        pitchFore.whileHeld(new MoveClimbingMotor());
        pitchAft.whileHeld(new MoveClimbingMotorBackwards());
        
        adjustUp.whenPressed(new KWindageUp());
        adjustLeft.whenPressed(new KWindageLeft());
        adjustRight.whenPressed(new KWindageRight());
        adjustDown.whenPressed(new KWindageDown());
    }
    
    public XboxController getXbox() {
        return xbox;
    }
}
