package step3.domain;

public class RacingResult {
	private String name;
	private int position;

	public RacingResult(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}