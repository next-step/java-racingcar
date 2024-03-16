package racingcar;

import java.util.Random;

public class Car {
	private int position;

	public Car() {
		position = 0;
	}

	public void move() {
		if(new Random().nextInt(10) >= 4) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}
}
