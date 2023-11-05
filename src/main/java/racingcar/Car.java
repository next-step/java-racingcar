package racingcar;


public class Car {
	private int location;

	public Car(int location) {
		this.location = location;
	}

	public void moveForward() {
		this.location++;
	}

	public int getLocation() {
		return location;
	}
}
