package racingcar.view;

import java.util.List;

import racingcar.domain.game.CarResult;
import racingcar.domain.game.RacingResult;

public class ResultView {

	public void printResultTitle() {
		System.out.println("실행결과");
	}

	public void printResult(RacingResult result) {
		for (CarResult carResult : result.getCarResults()) {
			System.out.print(carResult.getName() + " : ");
			drawPosition(carResult.getPosition());
		}
		System.out.println();
	}

	public void printWinners(List<String> winners) {
		String result = String.join(", ", winners);
		System.out.println(result + "가 최종 우승했습니다.");
	}

	private static void drawPosition(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
