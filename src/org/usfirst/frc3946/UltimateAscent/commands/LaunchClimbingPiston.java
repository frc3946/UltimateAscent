
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3946.UltimateAscent.commands.CommandBase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 10482352
 */
public class LaunchClimbingPiston extends CommandBase {
    
    public LaunchClimbingPiston() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
      
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
       
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    //6. retract vertical hooks fully
        climbingPiston.set(DoubleSolenoid.Value.kReverse);
        SmartDashboard.putString("Loader", "Reverse");
    // 7. Horizontal hooks forward-para not set 
        climbingMotor.set(Relay.Value.kForward);
        SmartDashboard.putString("Loader", "Reverse");
    // 8. extend vertical hooks
        climbingPiston.set(DoubleSolenoid.Value.kForward);
        SmartDashboard.putString("Loader", "Forward");
    // 9. move horizontal hooks forward 2º
        climbingMotor.set(Relay.Value.kForward);
        SmartDashboard.putString("Loader", "Reverse");
    // 10. extend vertical hooks fully 
        climbingPiston.set(DoubleSolenoid.Value.kForward);
        SmartDashboard.putString("Loader", "Forward");
    // 11. tilt rod forward till they hit next rung 
        climbingMotor.set(Relay.Value.kForward);
        SmartDashboard.putString("Loader", "Reverse");
    // 13. move horizontal hooks fully forward
        climbingMotor.set(Relay.Value.kForward);
        SmartDashboard.putString("Loader", "Reverse");
    // 14. rotate bumper deflector out
        deflector.set(Relay.Value.kForward);
        SmartDashboard.putString("Loader", "Reverse");
    // 15. retract vertical hooks till disengage 1st
        climbingPiston.set(DoubleSolenoid.Value.kReverse);
        SmartDashboard.putString("Loader", "Reverse");
    // 16. move horizontal hooks to full back position
        climbingMotor.set(Relay.Value.kForward);
        SmartDashboard.putString("Loader", "Reverse");
    // 17. retract vertical hooks fully
        climbingPiston.set(DoubleSolenoid.Value.kReverse);
        SmartDashboard.putString("Loader", "Reverse");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
