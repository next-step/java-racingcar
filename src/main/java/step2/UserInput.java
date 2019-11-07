package step2;

public class UserInput {

	private final int CAR_COUNT;

	private final int MOVE_COUNT;

	public UserInput(int CAR_COUNT, int MOVE_COUNT) {
		this.CAR_COUNT = CAR_COUNT;
		this.MOVE_COUNT = MOVE_COUNT;
	}

	public int getCAR_COUNT() {
		return CAR_COUNT;
	}

	public int getMOVE_COUNT() {
		return MOVE_COUNT;
	}
}
