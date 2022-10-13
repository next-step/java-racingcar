package step5.controller;

import step5.model.Cars;
import step5.model.Winners;
import step5.strategy.MoveStrategy;
import step5.view.output.OutputView;
import step5.view.output.OutputViewImpl;

public class RacingGameController {
	private static final int MIN_TRY_CNT = 1;

	private final String nameInput;
	private final int tryInput;
	private final MoveStrategy moveStrategy;

	public RacingGameController(String nameInput, int tryInput, MoveStrategy moveStrategy) {
		this.nameInput = nameInput;
		this.tryInput = tryInput;
		this.moveStrategy = moveStrategy;
	}

	public void racingGame() {
		if (nameInput.isBlank() || tryInput < MIN_TRY_CNT) {
			throw new IllegalArgumentException("자동차 댓수 또는 시도 횟수는 적어도 양수여야 합니다.");
		}

		OutputView outputView = new OutputViewImpl();
		Cars cars = new Cars(nameInput);

		for (int i = 0; i < tryInput; i++) {
			cars.decideMove(moveStrategy);
			outputView.printRacingResult(cars);
		}
		outputView.printWinner(new Winners().decideWinners(cars));
	}
}
