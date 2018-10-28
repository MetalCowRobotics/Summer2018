package org.usfirst.frc.team4213.robot;

import java.util.logging.Logger;

import org.usfirst.frc.team4213.lib14.PDController;
import org.usfirst.frc.team4213.systems.DriveTrain;

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

	public enum StartPosition {
		left, right, farRight
	};

	// Define Autonomous Missions //remove if enum works
	private final String rightSide = "RightSide";
	private final String leftSide = "LeftSide";
	private final String passLine = "PassLine";
	private final String eitherSide = "eitherSide";
	private final String leftSideOfScale = "leftSideOfScale";
	private final String leftPosition = "LeftPosition";
	private final String rightPosition = "RightPosition";
	private final String middlePosition = "MiddlePosition";

	private SendableChooser<String> autoChooser = new SendableChooser<>();
	private SendableChooser<String> positionChooser = new SendableChooser<>();
	private AutoMissionOptions mission = AutoMissionOptions.passLine;;
	private StartPosition position = StartPosition.right;
	private String autoSelected = passLine; // remove if enum works

	private PowerDistributionPanel pdp;
	private DriverStation driverStation;

	public void initializeDashboard() {
		//pdp = new PowerDistributionPanel();
		driverStation = edu.wpi.first.wpilibj.DriverStation.getInstance();
		// CameraServer.getInstance().startAutomaticCapture();
	}

	public void pushAutonomousMissions() {
		// Load available Autonomous missions to the driverstation
		autoSelected = rightSide;
		 autoChooser.addObject("Right Side Switch", rightSide);
		 autoChooser.addObject("Left Side Switch", leftSide);
		 autoChooser.addDefault("Pass Line", passLine);
		 autoChooser.addObject("Switch Either Side", eitherSide);
		 autoChooser.addObject("Left Scale", leftSideOfScale );
		 autoChooser.addObject("RightPosition", rightPosition);
		 autoChooser.addObject("LeftPosition", leftPosition);
		 autoChooser.addObject("MiddlePosition", middlePosition);
//		autoChooser.addDefault("Pass Line", AutoMissionOptions.passLine.name());
//		autoChooser.addObject("Right Side Switch", AutoMissionOptions.rightSwitch.name());
//		autoChooser.addObject("Left Side Switch", AutoMissionOptions.leftSwitch.name());
//		autoChooser.addObject("Switch Either Side", AutoMissionOptions.switchEitherSide.name());
//		autoChooser.addObject("Left Scale", AutoMissionOptions.leftScale.name());
//		autoChooser.addObject("Right Scale", AutoMissionOptions.rightScale.name());
//		autoChooser.addObject("Scale or Switch My Side", AutoMissionOptions.scaleOrSwitch.name());
//		autoChooser.addObject("Switch or Scale My Side", AutoMissionOptions.switchOrScale.name());
		SmartDashboard.putData("Auto choices", autoChooser);
	}

	public void pushStartPositions() {
		positionChooser.addObject("Left of Switch", StartPosition.left.name());
		positionChooser.addObject("Right side in front of Switch", StartPosition.right.name());
		positionChooser.addObject("Right of Switch", StartPosition.farRight.name());
		SmartDashboard.putData("Starting Position", positionChooser);
	}

	public String getSelectedMision() {
		// autoSelected = SmartDashboard.getString("Auto Selector",defaultAuto);
		return autoChooser.getSelected();
	}

	public AutoMissionOptions getAutoMision() {
		// autoSelected = SmartDashboard.getString("Auto
		// Selector",AutoMission.passLine.name());
		String missionString = autoChooser.getSelected();
		if (missionString.equals(AutoMissionOptions.rightSwitch.name()))
			return AutoMissionOptions.rightSwitch;
		if (missionString.equals(AutoMissionOptions.leftSwitch.name()))
			return AutoMissionOptions.leftSwitch;
		if (missionString.equals(AutoMissionOptions.switchMySide.name()))
			return AutoMissionOptions.switchMySide;
		if (missionString.equals(AutoMissionOptions.switchEitherSide.name()))
			return AutoMissionOptions.switchEitherSide;
		if (missionString.equals(AutoMissionOptions.scaleMySide.name()))
			return AutoMissionOptions.scaleMySide;
		if (missionString.equals(AutoMissionOptions.leftScale.name()))
			return AutoMissionOptions.leftScale;
		if (missionString.equals(AutoMissionOptions.rightScale.name()))
			return AutoMissionOptions.rightScale;
		if (missionString.equals(AutoMissionOptions.scaleOrSwitch.name()))
			return AutoMissionOptions.scaleOrSwitch;
		if (missionString.equals(AutoMissionOptions.switchOrScale.name()))
			return AutoMissionOptions.switchOrScale;
		return AutoMissionOptions.passLine;
	}

	public StartPosition getStartPosition() {
		// String positionSelected = SmartDashboard.getString("Starting
		// Position",defaultAuto, StartPosition.right.name());
		String positionString = positionChooser.getSelected();
		if (positionString.equals(StartPosition.left.name()))
			return StartPosition.left;
		if (positionString.equals(StartPosition.right.name()))
			return StartPosition.right;
		if (positionString.equals(StartPosition.farRight.name()))
			return StartPosition.farRight;
		return StartPosition.right;
	}


	public void pushGyro() {
		//SmartDashboard.putNumber("Gyro Reading", DriveTrain.getInstance().getAngle());
	}
	
}
