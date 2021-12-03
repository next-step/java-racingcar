package study.racingcar.domain;

import java.util.Objects;

import study.racingcar.domain.strategy.MoveStrategy;

public class Car {

	private final Name name;
	private Position position;

	public Car(String name, int position) {
		this.name = new Name(name);
		this.position = new Position(position);
	}

	public Car(Name name, Position position) {
		this.name = name;
		this.position = position;
	}

	public Car(String name, Position position) {
		this.name = new Name(name);
		this.position = position;
	}

	public Car(Name name) {
		this(name, new Position());
	}

	public Car(String name) {
		this(name, new Position());
	}


	public Car movedCar(MoveStrategy strategy) {
		if (strategy.isMovable()) {
			this.position = position.movedPosition();
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
