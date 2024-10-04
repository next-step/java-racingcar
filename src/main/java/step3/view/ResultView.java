package step3.view;

public final class ResultView {
	public static void printCurrentPosition(int[][] raceResult) {
		System.out.println("실행 결과");
		for (int moveIndex = 0; moveIndex < raceResult.length; moveIndex++) {
			printCarPositionWithMoveIndex(raceResult[moveIndex]);
		}
	}

	private static void printCarPositionWithMoveIndex(int[] raceResult) {
		for (int carIndex : raceResult) {
			printCarPositions(carIndex);
		}
		System.out.println("");
	}

	private static void printCarPositions(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}
}
