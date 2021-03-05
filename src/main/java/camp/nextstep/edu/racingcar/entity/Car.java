package camp.nextstep.edu.racingcar.entity;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

	public String getStepString() {
		return IntStream.range(0, step)
			.mapToObj(i -> "-")
			.collect(Collectors.joining(""));
	}
}
