package racingcar.domain.game;

public class CarResult {

	private final String name;
	private final int position;

	public CarResult(String name, int position) {
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
