package racingcar;

import java.util.List;

import racingcar.controller.RacingGameController;
import racingcar.domain.RacingCars;
import racingcar.domain.EngineRandomStrategy;
import racingcar.domain.CountOfGamePlay;
import racingcar.domain.CarNames;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.RoundResult;
import racingcar.view.ResultView;

public class RacingCarApplication {
	public static void main(String[] args) {
		new RacingGameController().play();
	}
}
