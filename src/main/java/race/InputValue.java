package race;

public class InputValue {
	private final int numberOfCar;
	private final int numberOfTryTimes;

	public InputValue(int numberOfCar, int numberOfTryTimes) {
		this.numberOfCar = numberOfCar;
		this.numberOfTryTimes = numberOfTryTimes;
	}

	public int numberOfCar() {
		return numberOfCar;
	}

	public int numberOfTryTimes() {
		return numberOfTryTimes;
	}
}
