package racing.view;

import racing.model.Result;

import java.util.List;

public class OutputView {

	private static final String POSITION_SIGN = "-";
	private static final String RESULT_DELIMITER = " : ";

	public static void printResultMessage() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public static void printResults(List<Result> results) {
		for (Result result : results) {
			printResult(result.getPosition(), result.getName());
			System.out.println();
		}
		System.out.println();
	}

	private static void printResult(int position, String name) {
		System.out.print(name);
		System.out.print(RESULT_DELIMITER);
		System.out.print(POSITION_SIGN.repeat(position));
	}
}
