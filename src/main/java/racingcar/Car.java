package racingcar;

public class Car {
	private final CarName carName;
	private int position;
	private final CarMoveStrategy[] carMoveStrategies;

	public Car (String carName, CarMoveStrategy... carMoveStrategies) {
		this.carName = new CarName(carName);
		position = 0;
		this.carMoveStrategies = carMoveStrategies;
	}

	public void move() {
		for(CarMoveStrategy carMoveStrategy : carMoveStrategies) {
			if(!carMoveStrategy.isMovable()) {
				return;
			}
		}
		position++;
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
