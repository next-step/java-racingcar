package racingcar.view;

import java.util.List;
import java.util.Map;

public class ResultView {

	public static final String MESSAGE_FOR_GAME_RESULT = "실행 결과";
	public static final String MESSAGE_FOR_WINNERS = "가 최종 우승했습니다.";
	public static final String COMMA = ",";
	public static final String HYPHEN = "-";
	public static final String COLON = " : ";

	public void renderResultMessage() {
		System.out.println(MESSAGE_FOR_GAME_RESULT);
	}

	public void renderResult(Map<String, Integer> gameResult) {
		gameResult.forEach((name, mileage) -> {
			System.out.print(name + COLON);
			for(int i = 0; i < mileage; i++) {
				System.out.print(HYPHEN);
			}
			System.out.println();
		});
		System.out.println();
	}

	public void renderWinner(List<String> winners) {
		if(winners.isEmpty()) {
			throw new IllegalArgumentException("우승자가 없습니다.");
		}
		System.out.print(winners.get(0));
		for (int i = 1; i < winners.size(); i++) {
			System.out.print(COMMA + winners.get(i));
		}
		System.out.println(MESSAGE_FOR_WINNERS);
	}
}
