package racing;

public class Command {
	public static final String DELIMITER = ",";

	private int count;
	private String[] names;

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
