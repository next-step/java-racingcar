package carrase;

public class RacingCar implements Car {
	private int mileage;

	public int getMileage() {
		return mileage;
	}

	@Override
	public void stop() {
		// nothing to do
	}

	@Override
	public void moveForward() {
		mileage += 1;
	}
}
