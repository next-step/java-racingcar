package step4.domain.view;

import step4.exception.RaceParamUnvalidException;

public class UserInput {
	int moveCount;
	String[] nameList;

	public UserInput(int moveCount, String nameString) {
		throwExceptionIfMoveCountIsNegative(moveCount);
		this.moveCount = moveCount;
		splitName(nameString);
	}

	private static void throwExceptionIfMoveCountIsNegative(int moveCount) {
		if (moveCount < 0) {
			throw new RaceParamUnvalidException();
		}
	}

	private static void throwExceptionWhenNameIsEmpty(String string) {
		if (string.isEmpty()) {
			throw new RaceParamUnvalidException();
		}
	}

	private void splitName(String nameString) {
		if (nameString.isEmpty()) {
			throw new RaceParamUnvalidException();
		}
		String[] tempList = nameString.split(",");
		for (String string : tempList) {
			throwExceptionWhenNameIsEmpty(string);
		}
		this.nameList = nameString.split(",");
	}

	public int getMoveCount() {
		return moveCount;
	}

	public String[] getNameList() {
		return nameList;
	}
}
