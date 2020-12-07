package step3.racingcar.ui;

import java.util.List;

import step3.racingcar.domain.RacingCar;
import step3.racingcar.domain.RacingCarGenerator;
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
		List<RacingCar> racingCars = new RacingCarGenerator().generate(participateCarCount);
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

		for (int i = 0; i < racingExecuteCountInput; i++) {
			for (RacingCar racingCar : racingCars) {
				racingCar.move(randomNumberGenerator.generate());
			}
		}
	}

}
