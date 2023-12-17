package racingcar.model;

public class Car {
	private Integer name;

	public Integer getName() {
		return name;
	}

	private Integer distance;

	public Integer getDistance() {
		return distance;
	}

	public Car() { }

	public Car(Integer name) {
		this.name = name;
		this.distance = 0;
	}

	public void move() {
		distance += 1;
	}
}
