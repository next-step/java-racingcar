package racingcar;

public class Car {
	private final CarName carName;
	private int position;
	private final CarMoveStrategy carMoveStrategy;

	public Car (String carName, CarMoveStrategy carMoveStrategy) {
		this.carName = new CarName(carName);
		position = 0;
		this.carMoveStrategy = carMoveStrategy;
	}

	public void move() {
		if(carMoveStrategy.isMovable()) {
			position++;
		}
	}

	public boolean isEqualPosition(int position) {
		return this.position == position;
	}

	public String getCarName() {
		return carName.getName();
	}

	public int getPosition() {
		return position;
	}
}
