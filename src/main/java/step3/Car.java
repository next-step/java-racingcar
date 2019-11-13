package step3;

import java.util.Objects;

public class Car {

	private String name;

	private int position;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int move(boolean isMove) {
		if (isMove) {
			this.position++;
		}
		return this.position;
	}

	public int printCarStatus() {
		StringBuilder result = new StringBuilder();

		result.append(this.name).append(" : ");
		for (int i = 0; i < this.position; i++) {
			result.append("-");
		}

		System.out.println(result);

		return this.position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return position == car.position &&
				Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
