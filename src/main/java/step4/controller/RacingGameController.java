package step4.controller;

import step3.util.numberGenerator.NumberGenerator;
import step3.util.numberGenerator.RandomNumberGenerator;
import step4.model.Cars;
import step4.model.Winners;
import step4.view.output.OutputView;
import step4.view.output.OutputViewImpl;

public class RacingGameController {

    private static final int MAX_BOUND = 10;

	public void racingGame(String nameInput, int tryCnt) {
        if(nameInput.length() < 1 || tryCnt < 1) throw new RuntimeException("자동차 댓수 또는 시도 횟수는 적어도 양수여야 합니다.");

        final Cars cars = new Cars();
        final Winners winners = new Winners();
        final OutputView outputView = new OutputViewImpl();
        final NumberGenerator numberGenerator = new RandomNumberGenerator();

		cars.init(nameInput);
		for (int i = 0; i < tryCnt; i++) {
			cars.getCars().forEach(car -> car.move(numberGenerator.generate(MAX_BOUND)));
			outputView.printRacingResult(cars);
		}
		winners.checkWinners(cars, winners.getWinnerStandard(cars));
		outputView.printWinner(winners);
	}
}
