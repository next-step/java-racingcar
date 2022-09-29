package racing.model;

public class Result {

	private int position;
	private String name;

	public Result(int position, String name) {
		this.position = position;
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
