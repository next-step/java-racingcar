package carrase;

public class RacingCar implements Car {
	private int mileage;
	private String name;

	public RacingCar(String name) {
		if(name.length() > 5) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public int getMileage() {
		return mileage;
	}

	public String getName() {
		return name;
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
