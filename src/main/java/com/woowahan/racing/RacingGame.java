package com.woowahan.racing;

import com.woowahan.racing.model.InputResult;
import com.woowahan.racing.model.RacingSimulator;
import com.woowahan.racing.view.InputView;
import com.woowahan.racing.view.ResultView;

public class RacingGame {

	public static void main(String[] args) {

		InputResult inputResult = InputResult.of(InputView.getCarCount(), InputView.getTryCount());
		RacingSimulator racingSimulator = RacingSimulator.getInstance(inputResult);
		ResultView.printResult(racingSimulator.run());

	}
}
