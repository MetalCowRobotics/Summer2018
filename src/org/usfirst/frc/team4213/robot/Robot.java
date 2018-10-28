package org.usfirst.frc.team4213.robot;

import java.util.logging.Logger;

import org.usfirst.frc.team4213.commands.PassLineMission;
import org.usfirst.frc.team4213.lib14.MCRCommand;
import org.usfirst.frc.team4213.systems.DriveTrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.c
 */
public class Robot extends IterativeRobot {
	private static final Logger logger = Logger.getLogger(Robot.class.getName());

	MCRCommand robotMission;

	// PowerDistributionPanel pdp;
	DriverStation driverStation;

	// Systems
	DriveTrain driveTrain;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		logger.setLevel(RobotMap.LogLevels.robotClass);
		logger.entering(this.getClass().getName(), "robotInit");
		// setup the smartdashboard
		RobotDashboard.getInstance().initializeDashboard();

		// Initialize Robot
		driverStation = DriverStation.getInstance();
		// CameraServer.getInstance().startAutomaticCapture(0);

		// Initialize Systems
		driveTrain = DriveTrain.getInstance();
		// calibrate Gyro
		//driveTrain.calibrateGyro();
		DriverStation.reportWarning("ROBOT SETUP COMPLETE!  Ready to Rumble!", false);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString line to get the
	 * auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the SendableChooser
	 * make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		logger.entering(this.getClass().getName(), "autonomousInit");
		robotMission = new PassLineMission();
		logger.exiting(getClass().getName(), "autonomousInit");
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		logger.entering(this.getClass().getName(), "autonomousPeriodic");
		robotMission.run();
		logger.exiting(this.getClass().getName(), "autonomousPeriodic");
	}

	/**
	 * This should be called before teleop for any initilizations
	 */
	@Override
	public void teleopInit() {
		logger.info("Teleop Init!");
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		driveTrain.drive();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testInit() {

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {

	}

}
