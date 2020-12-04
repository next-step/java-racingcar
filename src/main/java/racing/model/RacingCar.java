package racing.model;

public class RacingCar {

	private static final int FORWARD_CRITERIA = 4;

	private int forwardRecord;

	public RacingCar() {
	}

	public int getForwardRecord() {
		return forwardRecord;
	}

	public boolean isForward(int randomCount) {
		return randomCount >= FORWARD_CRITERIA;
	}

	public void recordResult(boolean isForward) {
		if (isForward) {
			this.forwardRecord += 1;
		}
	}
}
