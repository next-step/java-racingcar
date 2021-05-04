package racing;

import static racing.Constant.*;

public class Command {
	private final int count;
	private final String[] names;

	public Command(int moveCount, String nameLine) {
		this.count = moveCount;
		this.names = nameLine.split(DELIMITER);
	}

	public int getCount() {
		return count;
	}

	public String[] getNames() {
		return names;
	}
}
