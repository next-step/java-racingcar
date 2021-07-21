package racing;

import racing.service.CarService;
import racing.ui.InputView;
import racing.ui.ResultView;

public class RacingApplication {

	private static final String RESULT_MESSAGE = "실행결과";

	public static void main(String[] args) {
		InputView inputView = new InputView();
		CarService carService = new CarService(inputView.getCarCount());
		ResultView resultView = new ResultView();

		System.out.println(RESULT_MESSAGE);
		for (int i = 0; i < inputView.getRepeatCount(); i++) {
			resultView.result(carService.moveCars());
		}
	}

}
