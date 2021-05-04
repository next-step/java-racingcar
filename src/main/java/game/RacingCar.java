package game;

public class RacingCar {

	private final CarNameWrapper carNameWrapper;

	private final MovingDistanceWrapper movingDistanceWrapper;

	public RacingCar(String carName) {
		this.carNameWrapper = new CarNameWrapper(carName);
		this.movingDistanceWrapper = new MovingDistanceWrapper();
	}

	public CarNameWrapper getCarNameWrapper() {
		return carNameWrapper;
	}

	public MovingDistanceWrapper getDisplacement() {
		return movingDistanceWrapper;
	}

	public void move() {
		this.movingDistanceWrapper.move(getRandomDistance());
	}

	private int getRandomDistance() {
		return this.movingDistanceWrapper.makeRandomNumber();
	}
}
