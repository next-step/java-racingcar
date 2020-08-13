package step5.domain;

import java.util.Objects;

public class Car {
	private static final int CAN_MOVE_NUM = 4;

	private final CarName name;
	private int record;

	public Car(String name) {
		this.name = new CarName(name);
		this.record = 0;
	}

	public String getName() {
		return name.getValue();
	}

	public int getRecord() {
		return record;
	}

	public void moveForward(int number) {
		if (number >= CAN_MOVE_NUM) {
			record++;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return record == car.record &&
				name.equals(car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, record);
	}

}
