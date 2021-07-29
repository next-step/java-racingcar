package racingcar.model;

import racingcar.exception.OverFiveCarNameException;
import racingcar.strategy.MovableStrategy;

public class RacingCar {
	// 4. 클래스 변수(static) public -> protected -> package(default) -> private
	private static final int INITIAL_POSITION = 0;
	private static final int NAME_MAX_LENGTH = 5;

	// 5. 일반 변수 public -> protected -> package(default) -> private
	public int position;
	public String carName;
	private MovableStrategy movableStrategy;

	private void checkNameValidation(String carName) throws OverFiveCarNameException {
		if (carName.length() > NAME_MAX_LENGTH) {
			throw new OverFiveCarNameException("자동차 이름의 길이가 5를 초과합니다");
		}
	}

	public RacingCar(String carName, MovableStrategy movableStrategy) throws OverFiveCarNameException {
		checkNameValidation(carName);
		this.position = INITIAL_POSITION;
		this.carName = carName;
		this.movableStrategy = movableStrategy;
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
