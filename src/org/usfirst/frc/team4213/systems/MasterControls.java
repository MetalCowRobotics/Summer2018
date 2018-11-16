package org.usfirst.frc.team4213.systems;

import java.util.logging.Logger;

import org.usfirst.frc.team4213.lib14.XboxControllerMetalCow;
import org.usfirst.frc.team4213.robot.RobotMap;

public class MasterControls {
	private static final Logger logger = Logger.getLogger(MasterControls.class.getName());

	private static final XboxControllerMetalCow driver = new XboxControllerMetalCow(RobotMap.DriverController.USB_PORT);
	// private static final XboxControllerMetalCow operator = new
	// XboxControllerMetalCow(RobotMap.OperatorController.USB_PORT);

	private static final MasterControls instance = new MasterControls();

	private MasterControls() {
		// Intentionally Blank for Singleton
		logger.setLevel(RobotMap.LogLevels.masterControlsClass);
	}

	public static MasterControls getInstance() {
		return instance;
	}

	public double getYAxis() {
		return deadBand(driver.getLY());
	}

	public double getXAxis() {
		return deadBand(driver.getLX());
	}

	public double getRotation() {
		return deadBand(driver.getRX());
	}

	private double deadBand(double value) {
		// upper deadBand
		if (value >= .05)
			return value;
		// lower deadBand
		if (value <= .05)
			return value;
		// outside deadBand
		return 0;
	}
	public boolean swapMode() {
		return driver.getXButtonPressed();
	}
}