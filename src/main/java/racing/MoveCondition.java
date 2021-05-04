package racing;

import static racing.Constant.*;

public class MoveCondition {
	private final MoveStatus status;

	public MoveCondition() {
		int randomValue = (int)(Math.random() * CONDITION_MAX_RANDOM_VALUE);
		this.status = randomValue < CONDITION_BOUNDARY_VALUE ? MoveStatus.STOP : MoveStatus.FORWARD;
	}

	public MoveCondition(MoveStatus status) {
		this.status = status;
	}

	public MoveStatus getStatus() {
		return status;
	}
}
