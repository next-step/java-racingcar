package racingCar;

public class Car {
	private String status;
	private String name;

	public Car() {
		this.status = "";
	}

	public void move(String advanced) {
		this.status += advanced;
	}

	public String getStatus() {
		return this.status;
	}

	public void createName(String name) {
		if (5 < name.length()) {
			throw new RuntimeException();
		}
		this.name = name;
	}
}
