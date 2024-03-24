package racingcar;

public class MultipleStrategy implements CarMoveStrategy {
	private final CarMoveStrategy[] carMoveStrategies;

	public MultipleStrategy(CarMoveStrategy... carMoveStrategies) {
		this.carMoveStrategies = carMoveStrategies;
	}

	@Override
	public boolean isMovable() {
		for(CarMoveStrategy carMoveStrategy : carMoveStrategies) {
			if(!carMoveStrategy.isMovable()) {
				return false;
			}
		}

		return true;
	}
}
