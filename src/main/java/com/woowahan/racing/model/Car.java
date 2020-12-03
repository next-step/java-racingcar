package com.woowahan.racing.model;

public class Car {

	private String distance = "";

	private Car() {
	}

	private Car(String distance) {
		this.distance = distance;
	}

	public static Car getInstance() {
		return new Car();
	}

	public void move(boolean isWin) {
		if (isWin) {
			this.distance += "-";
		}
	}

	public String getDistance() {
		return distance;
	}

	public Car clone() {
		return new Car(this.distance);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Car{");
		sb.append("distance='").append(distance).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
