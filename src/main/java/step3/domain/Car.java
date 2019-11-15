package step3.domain;

import java.util.Objects;

public class Car {

	private String name;
	private int position;

	public Car(String name) {
		this.name = name;
	}

	public int move(boolean isMove) {
		if (isMove) {
			this.position++;
		}
		return this.position;
	}

	public String getCarStatus() {
		StringBuilder carStatus = new StringBuilder();

		carStatus.append(this.name).append(" : ");
		for (int i = 0; i < this.position; i++) {
			carStatus.append("-");
		}

		return carStatus.toString();
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	/*
		Q) 테스트를 하기 위해서 Set 메서드를 추가했습니다.
	 	가급적 Getter, Setter를 사용하지 말라고 하셨는데 이럴 때는 괜찮을까요?
	 */
	public void setPosition(int position) {
		this.position = position;
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
