package racing.model;

public class Car implements Forwardable {


	private static final int MAX_NAME_CHARACTER_LENGTH = 5;

	private static final int FORWARD_CRITERIA = 4;

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

	@Override
	public void speedUp(int randomNumber) {
		if (isForward(randomNumber)) {
			this.forwardPosition += 1;
		}
		this.racingRecord += 1;
	}

	private boolean isForward(int randomNumber) {
		return randomNumber >= FORWARD_CRITERIA;
	}
}
