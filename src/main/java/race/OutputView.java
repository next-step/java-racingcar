package race;

import java.util.stream.Collectors;

public class OutputView {
	private static final String WINNER_MESSAGE = "\n%s가 최종 우승했습니다.";

	public static void printDistanceStatus(RaceGameResult raceGameResult) {
		String result = raceGameResult.getHistory()
			.stream()
			.map(RaceGameResultMessage::parser)
			.collect(Collectors.joining(RaceGameResultMessage.TRY_SEPARATOR));

		System.out.println(result);
	}

	public static void printRaceGameWinner(RaceGameResult raceGameResult) {
		System.out.println(String.format(WINNER_MESSAGE, raceGameResult.getDistanceWinner()));
	}
}
