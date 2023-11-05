package racingcar;


public class Car {
	private Integer location;

	public Car(Integer location) {
		this.location = location;
	}

	public void moveForward() {
		this.location++;
	}

	public Integer getLocation() {
		return location;
	}
}
