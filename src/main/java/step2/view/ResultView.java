package step2.view;

import java.util.List;

public class ResultView {
	public void showResult(List<int[]> carPositionsList) {
		for (int[] carPositions : carPositionsList) {
			showPosition(carPositions);
		}
	}

	private void showPosition(int[] carPositions) {
		for (int pos : carPositions) {
			printPosition(pos);
		}
		System.out.println();
	}

	private void printPosition(int pos) {
		for (int i = 0; i <= pos; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
