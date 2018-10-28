package org.usfirst.frc.team4213.systems;

import java.util.logging.Logger;

import org.usfirst.frc.team4213.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.KilloughDrive;

public class DriveTrain {
	private static final Logger logger = Logger.getLogger(DriveTrain.class.getName());
	private static DriveTrain instance = new DriveTrain();
	protected KilloughDrive kiwiDrive;

	private MasterControls controller = MasterControls.getInstance();

	// private static final ADXRS450_Gyro GYRO = new ADXRS450_Gyro();

	private int inverted = 1;

	// Singleton
	protected DriveTrain() {
		logger.setLevel(RobotMap.LogLevels.driveTrainClass);
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

	public void calibrateGyro() {
		// DriverStation.reportWarning("Gyro Reading:" + +GYRO.getAngle(), false);
		// DriverStation.reportWarning("Calibrating gyro... ", false);
		// GYRO.calibrate();
		// DriverStation.reportWarning("... Done! ", false);
		// DriverStation.reportWarning("Gryo Reading: " + GYRO.getAngle(), false);
	}

	public void resetGyro() {
		// DriverStation.reportWarning("Gyro Before Reset: " + GYRO.getAngle(), false);
		// GYRO.reset();
		// DriverStation.reportWarning("Gryo After Reset: " + GYRO.getAngle(), false);
	}

	// public double getAngle() {
	// // return GYRO.getAngle();
	// }

	private void invert() {
		inverted = inverted * -1;
	}

}
