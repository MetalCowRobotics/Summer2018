package org.usfirst.frc.team4213.robot;

import java.util.logging.Level;

public class RobotMap {

	public final class DriverController {
		public static final int USB_PORT = 0;
	}

	public final class OperatorController {
		public static final int USB_PORT = 1;
	}

	public final class Sensors {
		public static final double MY_GYRO_CHANNEL = 1;
		public static final int RANGE_FINDER = 1;// Analog Input/Output
	}

	public static final class Drivetrain {
		public static final int LEFT_MOTOR = 2;// PWM
		public static final int BACK_MOTOR = 1;// PWM
		public static final int RIGHT_MOTOR = 0;// PWM
	}

	public final class Autonomous {

	}

	public static final class LogLevels {
		public static final Level robotClass = Level.WARNING;
		public static final Level RobotDashboardClass = Level.WARNING;
		public static final Level masterControlsClass = Level.WARNING;
		public static final Level driveTrainClass = Level.FINEST;
		public static final Level missionClass = Level.WARNING;
		public static final Level autoDriveClass = Level.WARNING;
		public static final Level componentBuilderClass = Level.WARNING;
	}

}
