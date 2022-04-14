package racingcar.domain;


public class Car {
	private int move = 0;

	public int run(MovingRule movingRule) {
		if (movingRule.isMoveCar()) {
			move++;
		}
		return move;
	}

	public int getMove() {
		return move;
	}
}
