package racing.model;

public class Car {

	private static final int FORWARD_CRITERIA = 4;

	private static final int MAX_NAME_CHARACTER_LENGTH = 5;

	private String name;

	private int forwardPosition;

	private int racingRecord;

	public Car() {
	}

	public Car(String name) {
		if (isValidateName(name)) {
			this.name = name;
		}
	}

	private boolean isValidateName(String name) {
		if (name == null || name.trim().isEmpty() || name.length() > MAX_NAME_CHARACTER_LENGTH) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public int getForwardPosition() {
		return forwardPosition;
	}

	public int getRacingRecord() {
		return racingRecord;
	}

	public boolean isForward(int randomCount) {
		return randomCount >= FORWARD_CRITERIA;
	}

	public void speedUp(int randomCount) {
		if (this.isForward(randomCount)) {
			this.forwardPosition += 1;
		}
		this.racingRecord += 1;
	}
}
