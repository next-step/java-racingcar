package step3.racingcar.ui;

import java.util.List;

import step3.racingcar.domain.RacingCar;
import step3.racingcar.domain.RacingCarGenerator;

public class RacingCarGame {

	private final InputView inputView;
	private final ResultView resultView;

	public RacingCarGame() {
		this.inputView = new InputView();
		this.resultView = new ResultView();
	}

	public void start() {
		ready();
	}

	private void ready() {
		int participateCarCount = inputView.participateCarCountInput();
		int racingExecuteCountInput = inputView.racingExecuteCountInput();
		List<RacingCar> racingCars = new RacingCarGenerator().generate(participateCarCount);
	}

}
