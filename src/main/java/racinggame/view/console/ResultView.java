package racinggame.view.console;

import java.util.List;
import racinggame.domain.RacingGameResult;

public class ResultView {

	private static final String DISPLAY_CHARACTER = "-";

	public static void printHeader() {
		System.out.println("실행 결과");
	}

	public static void print(RacingGameResult racingGameResult) {
		List<String> positions = racingGameResult.getPrintPositions(DISPLAY_CHARACTER);
		for(String position : positions) {
			System.out.println(position);
		}
		System.out.println();
	}

	public static void printRacingResult(RacingGameResult racingGameResult) {
		System.out.println(String.format("%s가 최종 우승했습니다.", racingGameResult.getWinnerNames()));
	}
}
