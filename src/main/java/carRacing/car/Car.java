package carRacing.car;

import carRacing.moveStrategy.MoveStrategy;
import java.util.Objects;

public class Car {

	private static final int LIMIT_CAR_NAME_LENGTH = 5;
	private int position;
	private String name;

	public Car() {
		this(0, "");
	}

	public Car(String name) {
		this(0, name);
	}

	public Car(int position, String name) {
		this.position = position;
		this.name = validLengthName(name);
	}

	public void moveCar(MoveStrategy moveStrategy) {
		if (moveStrategy.isForward()) {
			position++;
		}
	}

	public boolean isSamePosition(int position) {
		return position == this.position;
	}

	public int maxPosition(int maxPosition) {
		if (this.position > maxPosition) {
			return this.position;
		}
		return maxPosition;
	}

	public String validLengthName(String carName) {
		if (carName.length() >= LIMIT_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
		}
		return carName;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
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
		return Objects.hash(position, name);
	}
}
