package step4.controller;

import step4.model.Car;
import step4.model.Cars;
import step4.strategy.MoveStrategy;
import step4.strategy.RandomMoveStrategy;
import step4.model.Winners;
import step4.view.output.OutputView;
import step4.view.output.OutputViewImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {
	private static final int MIN_TRY_CNT = 1;
	private static final String SPLIT_STANDARD = ",";

	private final String nameInput;
	private final int tryInput;
	private final MoveStrategy moveStrategy;

	public RacingGameController(String nameInput, int tryInput, MoveStrategy moveStrategy) {
		this.nameInput = nameInput;
		this.tryInput = tryInput;
		this.moveStrategy = moveStrategy;
	}

	public void racingGame() {
		if (nameInput.isBlank() || tryInput < MIN_TRY_CNT)
			throw new IllegalArgumentException("자동차 댓수 또는 시도 횟수는 적어도 양수여야 합니다.");

		final Winners winners = new Winners();
		final OutputView outputView = new OutputViewImpl();

		Cars cars = initCars();

		for (int i = 0; i < tryInput; i++) {
			decideMove(cars);
			outputView.printRacingResult(cars);
		}

		outputView.printWinner(winners.getWinners(cars));
	}

	private Cars initCars() {
		String[] names = nameInput.split(SPLIT_STANDARD);
		return new Cars(Arrays.stream(names)
				.map(Car::new)
				.collect(Collectors.toList()));
	}
	private void decideMove(Cars cars) {
		cars.getCars()
				.forEach(car -> car.move(moveStrategy));
	}
}
