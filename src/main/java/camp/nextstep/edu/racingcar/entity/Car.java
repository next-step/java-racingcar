package camp.nextstep.edu.racingcar.entity;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.exception.UserException;

public class Car {
	private int step;
	private String name;

	private final static int MOVE_CONDITION = 4;
	private final static int MAX_NAME_SIZE = 5;

	public Car(String name) {
		if (name.length() > MAX_NAME_SIZE) {
			throw new UserException();
		}

		this.name = name;
		this.step = 0;
	}

	public void move(int number) {
		if (number >= MOVE_CONDITION) {
			this.step++;
		}
	}

	private String getStepString() {
		return IntStream.range(0, step)
			.mapToObj(i -> "-")
			.collect(Collectors.joining(""));
	}

	public int getStep() {
		return step;
	}

	public String getCarName() {
		return this.name;
	}

	public String getStepStringWithName() {
		return this.name + " : " + this.getStepString();
	}
}
