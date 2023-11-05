package calculator;

public class Calculator {

	public static int cal(String fullText) {
		if (isBlank(fullText)) {
			return 0;
		}
		return sumArray(toIntArray(split(fullText)));
	}

	private static boolean isBlank(String fullText) {
		return fullText == null || fullText.isBlank();
	}

	private static String[] split(String fullText) {
		return fullText.split(",|:");
	}

	private static int[] toIntArray(String[] textArray) {
		int[] intArray = new int[textArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = getNumber(textArray[i]);
		}
		return intArray;
	}

	private static int getNumber(String text) {
		int number = Integer.parseInt(text);
		if (number < 0) {
			throw new RuntimeException("숫자 이외의 값 혹은 음수가 입력되었습니다.");
		}
		return number;
	}

	private static int sumArray(int[] intArray) {
		int sum = 0;
		for (int number : intArray) {
			sum += number;
		}
		return sum;
	}
}
