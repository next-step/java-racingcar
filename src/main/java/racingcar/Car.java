package racingcar;

public class Car {
	private int position;
	private final CarMoveStrategy[] carMoveStrategies;

	public Car(CarMoveStrategy... carMoveStrategies) {
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

	public int getPosition() {
		return position;
	}
}
