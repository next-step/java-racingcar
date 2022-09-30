package racing.model;

public class Result {

	private int position;
	private String name;

	public Result(Position position, Name name) {
		this.position = position.getPosition();
		this.name = name.getName();
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
