package racingcar;

public class Car {

	public int position;

	public Car() {
		this.position = 0;
	}

	public int getPosition() {
		return position;
	}

	public String move(int number) {
		// 3 이하일 때 멈춤
		if (number <= 3) {
			return "";
		}

		position++;
		return "-";
	}
}
