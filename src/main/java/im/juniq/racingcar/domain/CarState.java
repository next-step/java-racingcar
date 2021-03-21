package im.juniq.racingcar.domain;

public class CarState {
	private String name;
	private int position;

	public CarState(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String name() {
		return name;
	}

	public int position() {
		return position;
	}
}