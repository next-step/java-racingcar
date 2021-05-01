package game;

public class RacingCar {

	private final CarName carName;

	private final int displacement;

	public RacingCar(String carName, int displacement) {
		this.carName = new CarName(carName);
		this.displacement = displacement;
	}

	public CarName getCarName() {
		return carName;
	}

	public int getDisplacement() {
		return displacement;
	}
}
