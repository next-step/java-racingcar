package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.CarNames;
import racingcar.domain.CountOfGamePlay;
import racingcar.domain.EngineRandomStrategy;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.view.RoundResult;

public class RacingGameController {

	public void play() {
		CarNames carNames = InputView.inputCarNames();
		int playCount = InputView.inputPlayCount();

		CountOfGamePlay countOfGamePlay = new CountOfGamePlay(playCount);

		RacingCars racingCars = RacingCars.of(carNames);

		List<RoundResult> results = new ArrayList<>();
		while (countOfGamePlay.racing()) {
			racingCars.play(new EngineRandomStrategy());
			countOfGamePlay.race();
		}

		// List<RoundResult> roundResults = countOfGamePlay.run(racingCars, new EngineRandomStrategy());

		// ResultView.printGameRound(roundResults);
		ResultView.printWinner(racingCars.rankWinners());
	}
}
