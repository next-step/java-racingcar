package racingcar;

public class ResultView {
	private static final String RESULT_HEAD_MESSAGE = "실행결과";

	public void printHead() {
		System.out.println(RESULT_HEAD_MESSAGE);
	}

	public void printPosition(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		printEmptyLine();
	}

	public void printEmptyLine() {
		System.out.println("");
	}
}
