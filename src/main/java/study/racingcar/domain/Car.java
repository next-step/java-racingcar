package study.racingcar.domain;

import java.util.Random;

import study.racingcar.view.ResultView;

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

	public void printRace() {
		ResultView.printRace(position);
	}

	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(10);
	}

}
