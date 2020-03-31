package racing.vo;

import racing.exception.OutOfBoundInputDataException;

public class MoveCount {

	private static final int INPUT_MIN_VALUE = 1;

	private final int count;
	
	public MoveCount(final int count) {

		if ( count < INPUT_MIN_VALUE ) {
			throw new OutOfBoundInputDataException(INPUT_MIN_VALUE);
		}
		this.count = count;
	}

	public boolean isNotInCycle(final int currentCycle) {
		return currentCycle < INPUT_MIN_VALUE || currentCycle > count;
	}
}
