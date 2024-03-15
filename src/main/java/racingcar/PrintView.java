package racingcar;

public class PrintView {
	private static final String RESULT_MESSAGE = "실행 결과";

	public static void printEmptyLine() {
		System.out.println();
	}

	public static void printResultMessage() {
		System.out.println("\n" + RESULT_MESSAGE);
	}

	public static void printCarMoving() {
		System.out.print("-");

		System.out.println("");
	}
}
