package step2_calculator;

/**
 * 라이브 클래스 분리 Test
 */
public class Positive {
	private final int number;

	public Positive(String s) {
		this.number = Integer.parseInt(s);
	}

	public int getNumber() {
		return this.number;
	}
}
