package step2_calculator;

/**
 * 라이브 클래스 분리 Test
 */
public class Positive {
	private static final String NEGATIVE_ERROR_MSG = "음수 값 발견";
	private static final String PARSEINT_ERROR_MSG = "NumberFormat 변환 중 오류 발생";
	private int[] numbers;

	public Positive(String[] values) {

		numbers = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			int number = toPositive(values[i]);
			numbers[i] = number;
		}
	}

	private int toPositive(String value)
	{
		try {
			int number = Integer.parseInt(value);

			if (number < 0) {
				throw new RuntimeException(NEGATIVE_ERROR_MSG);
			}
			return number;
		} catch (NumberFormatException e) {
			throw new RuntimeException(PARSEINT_ERROR_MSG);
		}
	}


	public int[] getNumbers() {
		return this.numbers;
	}
}
