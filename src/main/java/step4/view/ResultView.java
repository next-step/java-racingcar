package step4.view;

import java.util.List;
import java.util.Map;

import step4.domain.race.RaceResult;

public final class ResultView {
	public static void printRacingHistory(RaceResult raceResult) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("실행 결과\n");
		printRaceHistory(raceResult, stringBuilder);
		printWinner(raceResult, stringBuilder);
		System.out.println(stringBuilder);
	}

	private static void printRaceHistory(RaceResult raceResult, StringBuilder stringBuilder) {
		for (int moveTime = 0; moveTime < raceResult.getMovedCount(); moveTime++) {
			printHistoryByTime(raceResult.getNamePositionMapByTime(moveTime), stringBuilder);
		}
	}

	private static void printHistoryByTime(Map<String, Integer> namePositionMap, StringBuilder stringBuilder) {
		namePositionMap.forEach((name, position) -> {
			String hyphens = "-".repeat(position);
			stringBuilder.append(name).append(" : ").append(hyphens).append("\n");
		});
		stringBuilder.append("\n");
	}

	private static void printWinner(RaceResult raceResult, StringBuilder stringBuilder) {
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
