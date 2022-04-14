package racingcar.main;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingCar {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView(inputView);
		resultView.showResult();
	}
}
