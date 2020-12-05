package racing.model;

public class RacingCar {

	private static final int FORWARD_CRITERIA = 4;

	private int forwardRecord;

	private int racingRecord;

	public RacingCar() {
	}

	public int getForwardRecord() {
		return forwardRecord;
	}

	public int getRacingRecord() {
		return racingRecord;
	}

	public boolean isForward(int randomCount) {
		return randomCount >= FORWARD_CRITERIA;
	}

	public void speedUp(int randomCount) {
		if (this.isForward(randomCount)) {
			this.forwardRecord += 1;
		}
		this.racingRecord += 1;
	}
}
