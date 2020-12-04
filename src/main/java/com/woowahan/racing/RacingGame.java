package com.woowahan.racing;

import java.util.List;

import com.woowahan.racing.model.GameResult;
import com.woowahan.racing.model.InputResult;
import com.woowahan.racing.model.RacingSimulator;
import com.woowahan.racing.view.InputView;
import com.woowahan.racing.view.ResultView;

public class RacingGame {

	public static void main(String[] args) {

		InputResult inputResult = InputResult.of(InputView.getCarNames(), InputView.getTryCount());
		RacingSimulator racingSimulator = RacingSimulator.createSimulator(inputResult);
		List<GameResult> gameResults = racingSimulator.run();
		List<String> winners = racingSimulator.getWinners();
		ResultView.printResult(gameResults, winners);
	}
}
