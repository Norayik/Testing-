
package org.usfirst.frc.team696.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    /*
     * Joystics 
     */
    
	Joystick driver = new Joystick(1); 
	
	/*
	 * Compressor
	 */
	Compressor compressor = new Compressor(); 
	
    /*
    *  Encoders 
    */
	Encoder RightSide = new Encoder(2,3); 
	Encoder LeftSide = new Encoder(4,5); 
	
	/*
	 * Solenoids 
	 */
	Solenoid BackArm = new Solenoid(1); 
	Solenoid BackArm2 = new Solenoid(2); 
	Solenoid FrontArm = new Solenoid(3); 
	Solenoid Cylinder = new Solenoid(4); 
	Solenoid Shitf = new Solenoid(5); 
	
	/*
	 * doubles 
	 */
	double speed = driver.getRawAxis(1);
	/*
	 * doubles 
	 */
	double speed = driver.getRawAxis(1); 
	double wheel = driver.getRawAxis(4); 
	double LeftDrive = 0; 
	double RightDrive = 0; 
	
	
	/*
	 * Motor controllers 
	 */
	 Talon LeftIntake = new Talon(1); 
	 Talon ShotterDown = new Talon(2); 
	 Talon LeftFront = new Talon(3);
	 Talon LeftBack = new Talon(5);  // no port 4 
	 Talon RightBack = new Talon(6); 
	 Talon RightFront = new Talon(8);  // no port 7 
	 Talon ShooterUp = new Talon(9); 
	 Talon RightInatke = new Talon(10); 
	 
	 
	 
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	speed = driver.getRawAxis(1); 
    	wheel = driver.getRawAxis(4); 
    	LeftDrive = (speed - wheel); 
    	RightDrive = (wheel + speed); 
    	
    	/*
    	 * Shift buttons 
    	 */
    	
    	/*
    	 * Intake 
    	 */
    	if(driver.getRawButton(1) == true) { 
    		LeftIntake.set(1);
    	
    	}
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
