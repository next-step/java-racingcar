package racing.car;

import racing.car.domain.CarRacing;
import racing.car.view.InputView;
import racing.car.view.ResultView;

public class CarRacingMain {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		String carNames = inputView.inputCarNames();

		CarRacing carRacing = new CarRacing(carNames);

		int tryCount = inputView.inputTryCount();
		ResultView resultView = new ResultView();
		resultView.printStartLineText();
		while (tryCount-- > 0) {
			carRacing.race();
			resultView.printStatus(carRacing.getCars());
		}

		resultView.printWinners(carRacing.findWinners());
	}
}
