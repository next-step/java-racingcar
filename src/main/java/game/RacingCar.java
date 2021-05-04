package game;

public class RacingCar {

	private final CarName carName;

	private final MovingDistance movingDistance;

	public RacingCar(String carName) {
		this.carName = new CarName(carName);
		this.movingDistance = new MovingDistance();
	}

	public CarName getCarName() {
		return carName;
	}

	public MovingDistance getDisplacement() {
		return movingDistance;
	}

	public void move() {
		this.movingDistance.move(getRandomDistance());
	}

	private int getRandomDistance() {
		return this.movingDistance.makeRandomNumber();
	}
}
