package racingcar.model;

import racingcar.exception.NameValidationException;
import racingcar.strategy.MovableStrategy;

public class RacingCar {
	private static final int INITIAL_POSITION = 0;
	private static final int NAME_MAX_LENGTH = 5;

	private int position;
	private String carName;
	private MovableStrategy movableStrategy;

	public RacingCar(String carName, MovableStrategy movableStrategy) throws NameValidationException {
		checkNameValidation(carName);
		this.position = INITIAL_POSITION;
		this.carName = carName;
		this.movableStrategy = movableStrategy;
	}

	private void checkNameValidation(String carName) throws NameValidationException {
		if (carName.length() > NAME_MAX_LENGTH) {
			throw new NameValidationException("자동차 이름의 길이가 5를 초과합니다");
		}
	}

	public String getRacingCarDashString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < this.position; i++) {
			stringBuilder.append('-');
		}
		return stringBuilder.toString();
	}

	public void forward() {
		if (movableStrategy.isMovable()) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getCarName() {
		return carName;
	}
}
