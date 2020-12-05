package com.woowahan.racing.model;

import com.woowahan.racing.constant.Message;
import com.woowahan.racing.util.ValidationUtil;

public class Car {

	private String name = "";
	private String distance = "";

	private Car(String name) {
		this(name, "");
	}

	private Car(String name, String distance) {
		if (ValidationUtil.isLengthEmptyOrGreaterThanFive(name)) {
			throw new IllegalArgumentException(Message.MSG_NAME_LENGTH_EMPTY_OR_GREATER_THAN_5);
		}
		this.name = name;
		this.distance = distance;
	}

	public static Car createCar(String name) {
		return new Car(name);
	}

	public void move(boolean isWin) {
		if (isWin) {
			this.distance += "-";
		}
	}

	public String getName() {
		return name;
	}

	public int getDistanceLength() {
		return this.distance != null ? distance.length() : 0;
	}

	public String getDistance() {
		return distance;
	}

	public Car clone() {
		return new Car(this.name, this.distance);
	}
}
