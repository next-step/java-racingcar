package racingcar.domain;

public class Car {
	private int move = 0;

	public int run(int randomNumber) {
		if (GameRule.isMoveCar(randomNumber)) {
			move++;
		}
		return move;
	}
}
