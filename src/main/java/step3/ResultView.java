package step3;

import java.util.List;

public class ResultView {
	private static final String POSITION_SIGN = "-";

	public static void printResult(Records records) {
		System.out.println();
		System.out.println("실행 결과");

		records.getResult()
			.forEach(results -> {
				printResult(results);
				System.out.println();
			});
	}

	private static void printResult(List<Integer> results) {
		results.forEach(result -> {
			printResult(result);
			System.out.println();
		});
	}

	private static void printResult(Integer result) {
		for (int i = 0; i < result; i++) {
			System.out.print(POSITION_SIGN);
		}
	}
}
