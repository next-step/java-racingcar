package step3.domain;

public class CarAtMorningStrategy implements CarMoveStrategy {
	@Override
	public Integer speed() {
		return 2 * Car.DEFAULT_SPEED;
	}

	@Override
	public Integer getMovePosition(Integer randVal) {
		return randVal % 2 == 0 ? speed() : Car.STOP_SPEED;
	}
}
