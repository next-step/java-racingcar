package racingcar.view;

import java.util.List;

public class ResultView {

	public void printResult() {
		System.out.println("실행결과");
	}

	public void view(List<Integer> positions) {
		for (Integer position : positions) {
			drawCarPosition(position);
		}
		System.out.println();
	}

	private static void drawCarPosition(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
