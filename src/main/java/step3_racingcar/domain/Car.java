package step3_racingcar.domain;

import step3_racingcar.dto.CarDTO;

public class Car {

	private int position = 0;

	public void tryMove(boolean isMovable) {
		if (isMovable) {
			move();
		}
	}

	private void move() {
		position++;
	}

	public int getPosition() {
		return position;
	}

}
