package com.woowahan.racing;

import com.woowahan.racing.model.InputResult;
import com.woowahan.racing.model.RacingSimulator;
import com.woowahan.racing.view.InputView;
import com.woowahan.racing.view.ResultView;

public class RacingGame {

	public static void main(String[] args) {

		InputResult inputResult = InputResult.of(InputView.getCarCount(), InputView.getTryCount());
		System.out.println(inputResult);

		RacingSimulator racingSimulator = RacingSimulator.getInstance(inputResult);
		racingSimulator.run();
		ResultView.printResult(racingSimulator.getGameResultList());

	}
}
