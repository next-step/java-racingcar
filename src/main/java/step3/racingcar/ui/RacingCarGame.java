package step3.racingcar.ui;

import java.util.List;

import step3.racingcar.domain.RacingCar;
import step3.racingcar.domain.RacingCarGenerator;
import step3.racingcar.domain.RoundRecorder;
import step3.racingcar.number.RandomNumberGenerator;

public class RacingCarGame {

	private final InputView inputView;
	private final ResultView resultView;

	public RacingCarGame() {
		this.inputView = new InputView();
		this.resultView = new ResultView();
	}

	public void start() {
		int participateCarCount = inputView.participateCarCountInput();
		int racingExecuteCountInput = inputView.racingExecuteCountInput();

		RoundRecorder roundRecorder = new RoundRecorder(racingExecuteCountInput);

		List<RacingCar> racingCars = RacingCarGenerator.generate(participateCarCount);

		for (int round = 1; round <= racingExecuteCountInput; round++) {
			play(racingCars);
			roundRecorder.record(round, racingCars);
		}

		resultView.printResult(roundRecorder);

	}

	private void play(final List<RacingCar> racingCars) {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		for (RacingCar racingCar : racingCars) {
			racingCar.move(randomNumberGenerator.generate());
		}
	}

}
