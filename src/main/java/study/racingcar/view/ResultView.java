package study.racingcar.view;

public class ResultView {

	private static final String DASH = "-";
	private static final String PLAY_RESULT_MESSAGE = "실행결과";

	private ResultView() {
		throw new AssertionError();
	}

	public static void printStart() {
		System.out.println(PLAY_RESULT_MESSAGE);
	}

	public static void printRace(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print(DASH);
		}
		System.out.println();
	}

	public static void newLine() {
		System.out.println();
	}
}
