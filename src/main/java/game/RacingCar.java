package game;

public class RacingCar {

	private final String carName;

	private final int displacement;

	public RacingCar(String carName, int displacement) {
		this.carName = carName;
		this.displacement = displacement;
	}

	public String getCarName() {
		return carName;
	}

	public int getDisplacement() {
		return displacement;
	}
}
