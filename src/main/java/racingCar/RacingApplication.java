package racingCar;

import racingCar.controller.RacingCarGame;
import racingCar.view.ConsoleInputView;
import racingCar.view.ConsoleResultView;

public class RacingApplication { // 자동차 경주를 시작한다.
	public static void main(String[] args) {
		RacingCarGame racingCarGame = new RacingCarGame(new ConsoleInputView(), new ConsoleResultView());
		racingCarGame.run();
	}
}
