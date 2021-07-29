package carrase;

public class RacingCar implements Car {
	private int mileage;

	public int getMileage() {
		return mileage;
	}

	public void stop() {
		// nothing to do
	}

	public void moveForward() {
		mileage += 1;
	}
}
