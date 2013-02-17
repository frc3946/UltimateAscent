package org.usfirst.frc3946.UltimateAscent;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //Joysticks
    public static final int xboxController = 1;
    public static final int leftJoystick = 2;
    public static final int rightJoystick = 3;
    public static final int cypress = 4;
    
    //Buttons
    //public static final int Button = XboxController.ButtonType.kX.value;
    public static final int launchFrisbee = XboxController.ButtonType.kR.value;
    public static final int loadFrisbee = XboxController.ButtonType.kY.value;
    public static final int firePiston = XboxController.ButtonType.kX.value;
    public static final int ExtendClimbingPiston = XboxController.ButtonType.kA.value;
    public static final int Climb = XboxController.ButtonType.kB.value;
 
    //Motors
    public static final int leftJaguar = 1; //Blue
    public static final int rightJaguar = 2; //Green
    public static final int frisbeeFirstWheel = 3; //Yellow
    public static final int frisbeeSecondWheel = 4; //Orange
    
    //Relays (Spikes)
    //public static final int liftSpike = 1;
    public static final int compressorRelay = 1; //Red
    public static final int frisbeeLoader = 2; //Purple
    public static final int climbingMotor = 3; //Grey
    public static final int deflector = 4; //Brown
    
    //Solenoids
    public static final int pistonRetract1 = 1; //Red, Black Hose 
    public static final int pistonExtend1 = 2; //Yellow, White Hose
    public static final int pistonRetract2 = 3; //Orange, Black Hose 
    public static final int pistonExtend2 = 4; //Green, White Hose
    public static final int firePistonRetract = 5; //Purple, Black Hose 
    public static final int firePistonExtend = 6; //Blue, White Hose
    
    //Digital
    public static final int pressureSwitch = 1; //White
    public static final int accelerometer = 2;
    
    //Analog
    public static final int currentSensor = 1; //Black
    
    public static int offset = 0;
    public static int distance = 0;
}
