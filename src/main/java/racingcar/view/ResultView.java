package racingcar.view;

import java.util.List;

import racingcar.domain.Winners;

public class ResultView {

	private ResultView() {}

	public static void printGameRound(List<RoundResult> roundResults) {
		System.out.println("\n실행결과");
		for (RoundResult roundResult : roundResults) {
			roundResult.print();
		}
	}

	public static void printWinner(Winners winners) {
		System.out.println(winners.toString() + "가 최종 우승했습니다.");
	}
}
