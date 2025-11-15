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
		if (number < 0 || number > 9) {
			throw new IllegalArgumentException("0부터 9까지의 숫자만 입력할 수 있습니다.");
		}

		if (number <= 3) {
			return "";
		}

		++position;
		return "-";
	}
}
