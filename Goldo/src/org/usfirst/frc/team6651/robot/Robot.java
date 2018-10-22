package org.usfirst.frc.team6651.robot;

import org.usfirst.frc.team6651.robot.commands.AutoOutOfLine;
// import org.usfirst.frc.team6651.robot.commands.AutoMode1;
import org.usfirst.frc.team6651.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6651.robot.subsystems.Elevator;
import org.usfirst.frc.team6651.robot.subsystems.Grabber;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

	// SUB SYSTEMS
	public static DriveTrain driveTrain = new DriveTrain();
	public static Elevator elevator = new Elevator();
	public static Grabber grabber = new Grabber();
	public static OI oi;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<Command>();

    public void robotInit() {
		oi = new OI();
		
		// chooser = new SendableChooser();
		// chooser.addDefault("Default program", new AutoOutOfLine());
		// chooser.addObject("Default program", new AutoMode1());
		// SmartDashboard.putData("Auto Mode", chooser);
		autonomousCommand = new AutoOutOfLine();
    }
	

    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {  	
        // autonomousCommand = (Command) chooser.getSelected();
        
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start(); 		
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}