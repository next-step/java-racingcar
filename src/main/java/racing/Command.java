package racing;

public class Command {
	public static final String DELIMITER = ",";

	private int moveCount;
	private String[] names;

	public Command(int moveCount, String nameLine) {
		this.moveCount = moveCount;
		this.names = nameLine.split(DELIMITER);
	}

	public int getMoveCount() {
		return moveCount;
	}

	public String[] getNames() {
		return names;
	}
}
