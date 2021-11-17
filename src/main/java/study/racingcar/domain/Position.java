package study.racingcar.domain;

public class Position {

	private static final int INIT_POSITION = 0;

	private int position;

	public Position() {
		this.position = INIT_POSITION;
	}

	public void add() {
		this.position++;
	}

	public int valueOfPosition() {
		return position;
	}

}
