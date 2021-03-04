package camp.nextstep.edu.racingcar.entity;

public class Car {
	private int step;
	private final static int MOVE_CONDITION = 4;

	public Car() {
		this.step = 0;
	}

	public void move(int number) {
		if (number >= MOVE_CONDITION) {
			this.step++;
		}
	}

	public int getStep() {
		return step;
	}
}
