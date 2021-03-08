package im.juniq.racingcar;

public class RacingCar {
	private int id;
	private int moveCount = 0;

	public RacingCar(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getMoveCount() {
		return moveCount;
	}
}
