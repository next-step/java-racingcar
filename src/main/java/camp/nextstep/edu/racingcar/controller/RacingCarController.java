package camp.nextstep.edu.racingcar.controller;

import java.util.Arrays;
import java.util.List;

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
		String inputCarNames = inputView.getMakeUserCarInput();
		List<String> carNames = getCarNames(inputCarNames);
		int attemptCount = inputView.getMakeAttempt();

		List<Car> cars = racingCarGame.generateCars(carNames);

		outputView.showResult();
		for (int i = 0; i < attemptCount; i++) {
			racingCarGame.moveCars(cars);
			outputView.showCarSteps(racingCarGame.getCarStepString(cars));
		}

		outputView.showWinner(racingCarGame.getWinnerNames(cars));
	}

	private List<String> getCarNames(String input) {
		return Arrays.asList(input.split(","));
	}
}
