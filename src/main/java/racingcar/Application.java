package racingcar;

import racingcar.controller.RacingController;
import racingcar.rule.RandomMoveRule;

public class Application {
	public static void main(String[] args) {
		RandomMoveRule moveRule = new RandomMoveRule();
		RacingController racingController = new RacingController(moveRule);
		racingController.startGame();
	}
}
