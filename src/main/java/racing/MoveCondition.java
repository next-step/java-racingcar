package racing;

public class MoveCondition {
	public static final int BOUNDARY_VALUE = 4;
	public static final int SCOPE_MAX = 10;

	private final MoveStatus status;

	public MoveCondition() {

		int randomValue = (int)(Math.random() * SCOPE_MAX);
		this.status = randomValue < BOUNDARY_VALUE ? MoveStatus.STOP : MoveStatus.FORWARD;
	}

	public MoveCondition(MoveStatus status) {
		this.status = status;
	}

	public MoveStatus getStatus() {
		return status;
	}
}
