package step3_racingcar.domain;

import step3_racingcar.service.GameRule;

public class Car implements Cloneable {

	private int position = 0;

	public void tryMove() {
		if (GameRule.isCarMoving()) {
			move();
		} else {
			stop();
		}
	}

	private void move() {
		position++;
	}

	private void stop() {
	}

	public String getStatus() {
		StringBuilder status = new StringBuilder();
		for (int i = 0; i < position; i++) {
			status.append("-");
		}
		return status.toString();
	}

	@Override
	public Car clone() {
		try {
			return (Car)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
}
