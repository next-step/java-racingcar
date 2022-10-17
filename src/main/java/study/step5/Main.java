package study.step5;

import study.step5.controller.RacingGameController;

public class Main {
	static RacingGameController racingGameController = new RacingGameController();

	public static void main(String[] args) {
		racingGameController.ready();
		racingGameController.start();
		racingGameController.end();
	}
}
