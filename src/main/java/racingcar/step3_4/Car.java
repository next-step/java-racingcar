package racingcar.step3_4;

import java.util.Objects;

public class Car {

	private static final int INITIAL_POSITION = 0;
	private static final int MIN_MOVE_VALUE = 4;

	private Name name;
	private int position;

	public Car() {
		this(INITIAL_POSITION);
	}

	public Car(int position) {
		this.position = position;
	}

	public Car(Name name) {
		this.name = name;
		this.position = INITIAL_POSITION;
	}

	public int move(RandomValueGenerator randomValueGenerator) {
		if (randomValueGenerator.generate() >= MIN_MOVE_VALUE) {
			this.position++;
		}

		return position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Car car = (Car) o;
		return position == car.position && Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}

	public Name getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
