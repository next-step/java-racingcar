package racingwinner;

import racingwinner.service.CarService;
import racingwinner.service.CarWinners;
import racingwinner.ui.InputView;
import racingwinner.ui.ResultView;

public class RacingApplication {

	private static final String RESULT_MESSAGE = "실행결과";

	public static void main(String[] args) {
		InputView inputView = new InputView();
		CarService carService = new CarService(inputView.getCarNames());

		System.out.println(RESULT_MESSAGE);
		for (int i = 0; i < inputView.getRepeatCount(); i++) {
			ResultView.result(carService.moveCars());
		}

		ResultView.printWinner(CarWinners.selectWinners(carService.getCars()));
	}

}
