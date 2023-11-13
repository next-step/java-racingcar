package calculator;

public class PositiveNumber {
	private final Integer number;

	public PositiveNumber(Integer number) {
		if (number < 0) {
			throw new RuntimeException("숫자 이외의 값 혹은 음수가 입력되었습니다.");
		}
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
