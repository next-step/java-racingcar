package step3.domain;

public class CarAtNightStrategy implements CarMoveStrategy {
	@Override
	public Integer speed() {
		return Car.DEFAULT_SPEED;
	}

	@Override
	public Integer getMovePosition(Integer randVal) {
		return randVal % 3 == 0 ? speed() : Car.STOP_SPEED;
	}
}
