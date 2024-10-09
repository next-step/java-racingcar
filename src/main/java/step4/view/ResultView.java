package step4.view;

import step4.domain.MovedHistory;
import step4.domain.RacingHistory;

public final class ResultView {
	public static void printRacingHistory(RacingHistory raceResult) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("실행 결과\n");
		for (MovedHistory movedHistory : raceResult.getMovedHistories()) {
			printCarPositionsAtMoveTime(movedHistory, stringBuilder);
		}
		System.out.println(stringBuilder);
	}

	private static void printCarPositionsAtMoveTime(MovedHistory movedHistory, StringBuilder stringBuilder) {
		for (Integer carPosition : movedHistory.getCarPositions()) {
			printCarPositionAtMoveTime(carPosition, stringBuilder);
		}
		stringBuilder.append("\n");
	}

	private static void printCarPositionAtMoveTime(Integer carPosition, StringBuilder stringBuilder) {
		for (int i = 0; i < carPosition; i++) {
			stringBuilder.append("-");
		}
		stringBuilder.append("\n");
	}
}
