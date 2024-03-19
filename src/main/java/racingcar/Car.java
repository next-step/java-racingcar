package racingcar;

public class Car {
	private final String name;
	private int position;
	private final CarMoveStrategy[] carMoveStrategies;

	public Car (String name, CarMoveStrategy... carMoveStrategies) {
		this.name = name;
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

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
