package study.racingcar;

import java.util.Random;

public class Car {

	private int position;

	public Car() {
		this.position = 0;
	}

	public void go() {
		if (getRandomNumber() >= 4) {
			this.position++;
		}
	}

	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(10);
	}

	public void printRace() {
		ResultView.printRace(position);
	}
}
