package racingcar;

public class ResultView {
	public static void printMove(int moveCount) {
		for (int i = 0; i < moveCount; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
}
