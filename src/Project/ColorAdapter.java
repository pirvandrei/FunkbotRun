package Project;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class ColorAdapter extends Thread {
	public double colorState = 0;
	EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
	SampleProvider sp = colorSensor.getRedMode();

	public ColorAdapter() {
		this.setDaemon(true);
		this.start();
	}

	public void run() {
		while (true) {
			float[] sample = new float[sp.sampleSize()];
			sp.fetchSample(sample, 0);
			colorState = (double) sample[0];
			Thread.yield();
		}
	}

	public double getColorIntensity() {
		return colorState;
	}

}
