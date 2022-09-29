package racing.view;

import racing.model.Position;

import java.util.List;

public class OutputView {

	public static void printResultMessage() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public static void printResult(List<Position> result) {
		for (Position position : result) {
			printPosition(position.getPosition());
			System.out.println();
		}
		System.out.println();
	}

	private static void printPosition(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
	}
}
