package racingcar;

import racingcar.controller.GameController;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.NumberOverFourStrategy;
import racingcar.strategy.NumberStrategy;
import racingcar.strategy.RandomNumberStrategy;
import racingcar.view.InputView;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputView;
import racingcar.view.OutputViewImpl;

public class Game {

	private static final InputView INPUT_VIEW = new InputViewImpl();
	private static final OutputView OUTPUT_VIEW = new OutputViewImpl();
	private static final int RANDOM_NUMBER_BOUND_INCLUSIVE = 9;

	public static void main(String[] args) {
		NumberStrategy numberStrategy = new RandomNumberStrategy(RANDOM_NUMBER_BOUND_INCLUSIVE);
		MoveStrategy moveStrategy = new NumberOverFourStrategy(numberStrategy);
		GameController gameController = new GameController(INPUT_VIEW, OUTPUT_VIEW, moveStrategy);

		gameController.play();
	}
}
