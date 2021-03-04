package camp.nextstep.edu.racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;

import camp.nextstep.edu.racingcar.entity.Car;
import camp.nextstep.edu.racingcar.module.RacingCarGame;
import camp.nextstep.edu.racingcar.view.InputView;
import camp.nextstep.edu.racingcar.view.OutputView;

public class RacingCarController {

	private final RacingCarGame racingCarGame;
	private final InputView inputView;
	private final OutputView outputView;

	public RacingCarController() {
		this.racingCarGame = RacingCarGame.getInstance();
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void run() {
		int racingCarCount = inputView.getMakeCarInput();
		int attemptCount = inputView.getMakeAttempt();
		List<Car> cars = racingCarGame.generateCars(racingCarCount);

		outputView.showResult();
		IntStream.range(0, attemptCount)
			.forEach(key -> {
				List<Car> movingCars = racingCarGame.moveCars(cars);
				outputView.showCarSteps(racingCarGame.getCarStepString(movingCars));
			});
	}
}
