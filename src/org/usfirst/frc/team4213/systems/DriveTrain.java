package org.usfirst.frc.team4213.systems;

import java.util.logging.Logger;

import org.usfirst.frc.team4213.lib14.UtilityMethods;
import org.usfirst.frc.team4213.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.KilloughDrive;

public class DriveTrain {

	private static final Logger myLogger = Logger.getLogger(DriveTrain.class.getName());
	private MasterControls controller = MasterControls.getInstance();
	protected KilloughDrive kiwiDrive;
	private static DriveTrain instance = new DriveTrain();
	private static final ADXRS450_Gyro GYRO = new ADXRS450_Gyro();
	private boolean fieldDrive = true;

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
		if (controller.swapMode())
			fieldDrive = !fieldDrive;
		if (fieldDrive)
			kiwiDrive.driveCartesian(controller.getYAxis(), controller.getXAxis(),
					limitRotation(controller.getRotation()), getAngle());
		else
			kiwiDrive.driveCartesian(controller.getYAxis(), controller.getXAxis(),
					limitRotation(controller.getRotation()));
	}

	public void stop() {
		kiwiDrive.stopMotor();
	}

	private double limitRotation(double rotationSpeed) {
		double absoluteRotation = Math.min(RobotMap.Drivetrain.maxRotation, Math.abs(rotationSpeed));
		return UtilityMethods.copySign(rotationSpeed, absoluteRotation);
	}

	public void calibrateGyro() {
		DriverStation.reportWarning("Gyro Reading:" + +GYRO.getAngle(), false);
		DriverStation.reportWarning("Calibrating gyro... ", false);

		GYRO.calibrate();

		DriverStation.reportWarning("... Done! ", false);
		DriverStation.reportWarning("Gryo Reading: " + GYRO.getAngle(), false);
	}

	public void resetGyro() {
		DriverStation.reportWarning("Gyro Before Reset: " + GYRO.getAngle(), false);
		GYRO.reset();
		DriverStation.reportWarning("Gryo After Reset: " + GYRO.getAngle(), false);
	}

	public double getAngle() {
		return GYRO.getAngle();
	}
}
