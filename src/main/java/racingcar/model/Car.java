package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public class Car {
	private String name;

	public String name() {
		return name;
	}

	private Integer distance;

	public Integer distance() {
		return distance;
	}

	public Car(String name) {
		this.name = name;
		this.distance = 0;
	}

	public void move() {
		if (RandomNumberGenerator.randomNumber() >= 4) {
			distance++;
		}
	}
}
