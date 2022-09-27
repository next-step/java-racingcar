package racingCar;

public class Car {
	private String status;

	public Car() {
		this.status = "";
	}

	public void move(String advanced) {
		this.status += advanced;
	}

	public String getStatus() {
		return this.status;
	}
}
