package calculator;

import java.util.Objects;

public class InputNumber {
	private double number;
	private String [] numbers;

	public InputNumber(double number) {
		this.number = number;
	}

	public InputNumber(String number) {
		if (Objects.isNull(number)) {
			throw new IllegalArgumentException("입력값은 null이 될 수 없습니다.");
		}
		if (number.isEmpty() || number.equals(" ")) {
			throw new IllegalArgumentException("입력값은 공백이 될 수 없습니다.");
		}

		this.numbers = number.split(" ");
	}

	public String[] getInputNumbers() {
		return numbers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InputNumber that = (InputNumber)o;
		return Double.compare(that.number, number) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
