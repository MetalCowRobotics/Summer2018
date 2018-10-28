package org.usfirst.frc.team4213.robot;

import java.util.logging.Logger;

import org.usfirst.frc.team4213.lib14.PDController;
import org.usfirst.frc.team4213.systems.Climber;
import org.usfirst.frc.team4213.systems.DriveTrain;
import org.usfirst.frc.team4213.systems.Elevator;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotDashboard {
	private static final Logger logger = Logger.getLogger(RobotDashboard.class.getName());
	private static org.usfirst.frc.team4213.robot.RobotDashboard ourInstance = new org.usfirst.frc.team4213.robot.RobotDashboard();

	public static org.usfirst.frc.team4213.robot.RobotDashboard getInstance() {
		return ourInstance;
	}

	private RobotDashboard() {
		logger.setLevel(RobotMap.LogLevels.RobotDashboardClass);
	}

	public enum AutoMissionOptions {
		passLine, rightSwitch, leftSwitch, switchMySide, switchEitherSide, scaleMySide, leftScale, rightScale, scaleOrSwitch, switchOrScale
	};


	private PowerDistributionPanel pdp;
	private DriverStation driverStation;

	public void initializeDashboard() {
		//pdp = new PowerDistributionPanel();
		// CameraServer.getInstance().startAutomaticCapture();
		SmartDashboard.putBoolean("Auto Position For Second Cube", RobotMap.Autonomous.SecondaryCube);
	}


	public void pushGyro() {
		//SmartDashboard.putNumber("Gyro Reading", DriveTrain.getInstance().getAngle());
	}
	
	public boolean doSecondaryMission() {
		return SmartDashboard.getBoolean("Auto Position For Second Cube", RobotMap.Autonomous.SecondaryCube);
	}
	
}
