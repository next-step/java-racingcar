package racingcar.model;

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

	public Car(String name, Integer distance) {
		this.name = name;
		this.distance = distance;
	}

	public void move(int randomNumber) {
		if (randomNumber >= 4) {
			distance++;
		}
	}
}
