package racingCar;

import racingCar.game.RacingCarGame;
import racingCar.ui.ConsoleInputView;
import racingCar.ui.ConsoleResultView;

public class RacingApplication { // 자동차 경주를 시작한다.
	public static void main(String[] args) {
		RacingCarGame racingCarGame = new RacingCarGame(new ConsoleInputView(), new ConsoleResultView());
		racingCarGame.run();
	}
}
