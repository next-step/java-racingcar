package step3.racingcar.ui;

import step3.racingcar.domain.RacingCarGenerator;
import step3.racingcar.domain.RacingCars;
import step3.racingcar.domain.RoundRecorder;

public class RacingCarGame {

	private final InputView inputView;
	private final ResultView resultView;

	public RacingCarGame() {
		this.inputView = new InputView();
		this.resultView = new ResultView();
	}

	public void start() {
		final String[] carNames = inputView.InputCarNames();
		final int racingExecuteCountInput = inputView.racingExecuteCountInput();

		RoundRecorder roundRecorder = new RoundRecorder(racingExecuteCountInput);

		RacingCars racingCars = RacingCarGenerator.generate(carNames);

		for (int round = 1; round <= racingExecuteCountInput; round++) {
			racingCars.moveAll();
			roundRecorder.record(round, racingCars);
		}

		resultView.printResult(roundRecorder);

	}

}
