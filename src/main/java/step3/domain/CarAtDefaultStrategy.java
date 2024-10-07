package step3.domain;

public class CarAtDefaultStrategy implements CarMoveStrategy {
	public static final int MIN_MOVE_VALUE = 4;

	@Override
	public Integer speed() {
		return Car.DEFAULT_SPEED;
	}

	@Override
	public Integer getMovePosition(Integer randVal) {
		return randVal >= MIN_MOVE_VALUE ? speed() : Car.STOP_SPEED;
	}
}
