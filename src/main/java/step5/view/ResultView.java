package step5.view;

import java.util.List;

import step5.domain.race.CarPositionMap;
import step5.domain.race.RaceHistory;

public final class ResultView {
	public static void printRacingHistory(RaceHistory raceResult) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("실행 결과\n");
		printRaceHistory(raceResult, stringBuilder);
		printWinner(raceResult, stringBuilder);
		System.out.println(stringBuilder);
	}

	private static void printRaceHistory(RaceHistory raceResult, StringBuilder stringBuilder) {
		for (int moveTime = 0; moveTime < raceResult.getMovedTime(); moveTime++) {
			printHistoryByTime(raceResult.getRaceHistoryByTime(moveTime), stringBuilder);
		}
	}

	private static void printHistoryByTime(CarPositionMap namePositionMap, StringBuilder stringBuilder) {
		namePositionMap.getCarPositionMap().forEach((name, position) -> {
			String hyphens = "-".repeat(position.get());
			stringBuilder.append(name).append(" : ").append(hyphens).append("\n");
		});
		stringBuilder.append("\n");
	}

	private static void printWinner(RaceHistory raceResult, StringBuilder stringBuilder) {
		List<String> winnerName = raceResult.getWinnerNameList();
		for (int i = 0; i < winnerName.size(); i++) {
			if (i > 0) {
				stringBuilder.append(", ");
			}
			stringBuilder.append(winnerName.get(i));
		}
		stringBuilder.append("가 최종 우승했습니다.");
	}

	public static void handleUnexpectedParams(Exception exception) {
		System.out.println(exception.getMessage());
	}
}
