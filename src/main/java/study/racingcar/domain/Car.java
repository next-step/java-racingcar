package study.racingcar.domain;

import java.util.Objects;

import study.racingcar.domain.strategy.MoveStrategy;

public class Car {

	public static final int INIT_POSITION = 0;

	private final Name name;
	private Position position;

	public Car(Name name, int position) {
		this.name = name;
		this.position = new Position(position);
	}

	public Car(Name name) {
		this(name, INIT_POSITION);
	}

	public Car go(MoveStrategy strategy) {
		if (strategy.isMovable()) {
			this.position = position.move();
		}
		return this;
	}

	public int carPosition() {
		return this.position.value();
	}

	public boolean isMaxPosition(int position) {
		return this.position.equals(new Position(position));
	}

	public Name carName() {
		return name;
	}

	public String valueOfCarName() {
		return name.value();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
