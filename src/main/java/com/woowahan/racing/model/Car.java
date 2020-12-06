package com.woowahan.racing.model;

import com.woowahan.racing.constant.Message;
import com.woowahan.racing.util.ValidationUtil;

public class Car {

	private String name = "";
	private int distance = 0;

	private Car(String name) {
		this(name, 0);
	}

	private Car(String name, int distance) {
		if (!ValidationUtil.validateCarName(name)) {
			throw new IllegalArgumentException(Message.MSG_CAR_NAME_LENGTH_ERROR);
		}
		this.name = name;
		this.distance = distance;
	}

	public static Car create(String name) {
		return new Car(name);
	}

	public void move(boolean isWin) {
		if (isWin) {
			this.distance += 1;
		}
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}

	public Car clone() {
		return new Car(this.name, this.distance);
	}
}
