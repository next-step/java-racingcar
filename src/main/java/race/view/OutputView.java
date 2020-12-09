package race.view;

import race.domain.RaceGameResult;

public class OutputView {
	private static final String WINNER_MESSAGE = "\n%s가 최종 우승했습니다.";

	public static void printDistanceStatus(RaceGameResult raceGameResult) {
		System.out.println(raceGameResult.getGameResults());
	}

	public static void printRaceGameWinner(RaceGameResult raceGameResult) {
		System.out.println(String.format(WINNER_MESSAGE, raceGameResult.getDistanceWinner()));
	}
}
