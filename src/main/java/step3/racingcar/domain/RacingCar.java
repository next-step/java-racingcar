package step3.racingcar.domain;

public class RacingCar {
	private int moveDistance;

	public void move(final int value) {
		if (value < 4) {
			return;
		}

		this.increaseMoveDistance();
	}

	private void increaseMoveDistance() {
		this.moveDistance += 1;
	}

	public int getMoveDistance() {
		return this.moveDistance;
	}
}
