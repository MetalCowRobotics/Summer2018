package org.usfirst.frc.team4213.systems;

import java.util.logging.Logger;

import org.usfirst.frc.team4213.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.KilloughDrive;

public class DriveTrain {
	private static final Logger myLogger = Logger.getLogger(DriveTrain.class.getName());
	private MasterControls controller = MasterControls.getInstance();
	protected KilloughDrive kiwiDrive;
	private static DriveTrain instance = new DriveTrain();

	// Singleton
	protected DriveTrain() {
		myLogger.setLevel(RobotMap.LogLevels.driveTrainClass);
		kiwiDrive = new KilloughDrive(new Spark(RobotMap.Drivetrain.LEFT_MOTOR),
				new Talon(RobotMap.Drivetrain.RIGHT_MOTOR), new Talon(RobotMap.Drivetrain.BACK_MOTOR));
	}

	public static DriveTrain getInstance() {
		return instance;
	}

	public void drive() {
		kiwiDrive.driveCartesian(controller.getYAxis(), controller.getXAxis(), controller.getRotation());
	}
	
	public void stop() {
		kiwiDrive.stopMotor();
	}
}
