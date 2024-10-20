package step5.dto;

import step5.exception.RaceParamUnvalidException;

public class UserInput {
	private static final int MIN_MOVE_COUNT = 1;

	private final String nameString;
	private final Integer moveCount;

	public UserInput(int moveCount, String nameString) {
		throwExceptionIfParamUnvalid(moveCount, nameString);
		this.moveCount = moveCount;
		this.nameString = nameString;
	}

	private static void throwExceptionIfParamUnvalid(int moveCount, String nameString) {
		if (moveCount < MIN_MOVE_COUNT || nameString == null || nameString.isEmpty()) {
			throw new RaceParamUnvalidException();
		}
	}

	public Integer getMoveCount() {
		return moveCount;
	}

	public String getNameString() {
		return nameString;
	}
}
