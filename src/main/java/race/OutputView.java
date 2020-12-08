package race;

import java.util.stream.Collectors;

public class OutputView {
	private static final String WINNER_MESSAGE = "\n%s가 최종 우승했습니다.";

	public static void printDistanceStatus(RaceGameHistory raceGameHistory) {
		String result = raceGameHistory.getHistory()
			.stream()
			.map(RaceGameResultMessage::parser)
			.collect(Collectors.joining(RaceGameResultMessage.TRY_SEPARATOR));

		System.out.println(result);
	}

	public static void printRaceGameWinner(RaceGameHistory raceGameHistory) {
		System.out.println(String.format(WINNER_MESSAGE, raceGameHistory.getDistanceWinner()));
	}
}
