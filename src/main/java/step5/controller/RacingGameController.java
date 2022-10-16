package step5.controller;

import step5.model.Cars;
import step5.model.TryCount;
import step5.model.Winners;
import step5.strategy.MoveStrategy;
import step5.view.output.OutputView;
import step5.view.output.OutputViewImpl;

import java.util.stream.IntStream;

public class RacingGameController {

	private final String nameInput;
	private final TryCount tryCount;
	private final MoveStrategy moveStrategy;

	public RacingGameController(String nameInput, int tryInput, MoveStrategy moveStrategy) {
		this.nameInput = nameInput;
		this.tryCount = new TryCount(tryInput);
		this.moveStrategy = moveStrategy;
	}

	public void racingGame() {
		if (nameInput.isBlank()) {
			throw new IllegalArgumentException("이름은 적어도 한 글자 이상이어야 합니다.");
		}

		OutputView outputView = new OutputViewImpl();
		Cars cars = Cars.inits(nameInput);

		IntStream.range(0, tryCount.getCount())
				.forEachOrdered(i -> {
					cars.decideMove(moveStrategy);
					outputView.printRacingResult(cars);
		});
		outputView.printWinner(new Winners(cars).getWinners());
	}
}
