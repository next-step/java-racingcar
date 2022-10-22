package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Cars;
import racingcar.dto.Result;
import racingcar.strategy.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	private final InputView inputView;
	private final OutputView outputView;
	private final MoveStrategy moveStrategy;

	public GameController(InputView inputView, OutputView outputView, MoveStrategy moveStrategy) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.moveStrategy = moveStrategy;
	}

	public void play() {
		List<String> names = inputView.readNames();
		Cars cars = Cars.ofNames(names);

		int trialCount = inputView.readTrialCount();

		List<Result> results = play(cars, trialCount);

		outputView.printResults(results);
		outputView.printWinners(cars.findWinnerNames());
	}

	private List<Result> play(Cars cars, int trialCount) {
		List<Result> results = new ArrayList<>();
		for (int i = 0; i < trialCount; ++i) {
			cars.move(moveStrategy);
			results.add(new Result(cars));
		}
		return results;
	}
}
