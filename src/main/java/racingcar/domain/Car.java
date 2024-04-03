package racingcar.domain;

import java.util.Objects;

public class Car {
	public static final int MIN_THRESHOLD = 4;
	private final Name name;
	private final Position position;

	public Car(Name name,  Position position) {
		this.name = name;
		this.position = position;
	}

	public Car(String name,  int position) {
		this(new Name(name), new Position(position));
	}

	public void moveStrategy(int randomNum) {
		if (randomNum >= MIN_THRESHOLD) {
			position.moveForward();
		}
	}
	public Position max(Position other) {
		return this.position.max(other);
	}

	public boolean isMatch(Position maxPosition) {
		return this.position.equals(maxPosition);
	}

	public Position position(){
		return this.position;
	}

	public Name name(){
		return this.name;
	}

	public boolean comparePosition(Position maxPosition) {
		return Objects.equals(position, maxPosition);
	}

}
