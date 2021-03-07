package camp.nextstep.edu.racingcar.entity;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.racingcar.module.MovingStrategy;

public class Car {

	private int step;
	private final Name name;

	public Car(String name) {
		this.name = new Name(name);
		this.step = 0;
	}

	public void move(MovingStrategy movingStrategy) {
		if (movingStrategy.moveable()) {
			this.step++;
		}
	}

	private String getStepString() {
		return IntStream.range(0, step)
			.mapToObj(i -> "-")
			.collect(Collectors.joining(""));
	}

	public boolean isWinner(int step) {
		return this.step == step;
	}

	public int getStep() {
		return step;
	}

	public Name getName() {
		return this.name;
	}

	public String getStepStringWithName() {
		return this.name + " : " + this.getStepString();
	}
}
