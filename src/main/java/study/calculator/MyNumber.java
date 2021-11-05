package study.calculator;

import java.util.Objects;

public class MyNumber {

	public static final String WRONG_DENOMINATOR_MSG = "분모는 0이 될 수 없습니다.";
	private final int number;

	public MyNumber(String number) {
		this(Integer.parseInt(number));
	}

	public MyNumber(int number) {
		this.number = number;
	}

	public MyNumber plus(MyNumber other) {
		return new MyNumber(this.number + other.number);
	}
	public MyNumber minus(MyNumber other) {
		return new MyNumber(this.number - other.number);
	}
	public MyNumber multiply(MyNumber other) {
		return new MyNumber(this.number * other.number);
	}
	public MyNumber divide(MyNumber other) {
		if (other.number == 0) {
			throw new IllegalArgumentException(WRONG_DENOMINATOR_MSG);
		}
		return new MyNumber(this.number / other.number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MyNumber myNumber = (MyNumber)o;
		return number == myNumber.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
