package racing.model;

public class Car {

	private static final int FORWARD_CRITERIA = 4;

	private String name;

	private int forwardPosition;

	private int racingRecord;

	public Car() {
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
