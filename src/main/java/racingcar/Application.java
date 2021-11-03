package racingcar;

import racingcar.controller.RacingController;
import racingcar.generator.Generator;
import racingcar.generator.RandomGenerator;

public class Application {
	public static void main(String[] args) {
		Generator generator = new RandomGenerator();
		RacingController racingController = new RacingController(generator);

		racingController.startGame();
	}
}
