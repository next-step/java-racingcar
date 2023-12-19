package racingcar.model;

public class Car {
	private String name;

	public String getName() {
		return name;
	}

	private Integer distance;

	public Integer getDistance() {
		return distance;
	}

	public Car(String name) {
		this.name = name;
		this.distance = 0;
	}

	public void move() {
		distance += 1;
	}
}
