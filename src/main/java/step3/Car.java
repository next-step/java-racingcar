package step3;

public class Car {
	private String status;

	public Car() {
		this.status = "";
	}

	public String move(String advanced) {
		return this.status += advanced;
	}
}
