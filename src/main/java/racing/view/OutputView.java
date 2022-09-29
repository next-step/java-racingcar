package racing.view;

import racing.model.Result;

import java.util.List;

public class OutputView {

	private static final String POSITION_SIGN = "-";
	private static final String COLON = " : ";
	private static final String COMMA = ", ";

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
		System.out.print(COLON);
		System.out.print(POSITION_SIGN.repeat(position));
	}

	public static void printWinners(List<String> winners) {
		System.out.println(String.join(COMMA, winners) + "가 최종 우승했습니다.");
	}
}
