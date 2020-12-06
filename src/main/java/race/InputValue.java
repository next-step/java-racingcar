package race;

public class InputValue {
	private String names;
	private int numberOfCar;
	private final int numberOfTryTimes;

	public InputValue(int numberOfCar, int numberOfTryTimes) {
		this.numberOfCar = numberOfCar;
		this.numberOfTryTimes = numberOfTryTimes;
	}

	public InputValue(String names, int numberOfTryTimes) {
		this.names = names;
		this.numberOfTryTimes = numberOfTryTimes;
	}

	public String names() {
		return names;
	}

	public int numberOfCar() {
		return numberOfCar;
	}

	public int numberOfTryTimes() {
		return numberOfTryTimes;
	}
}
