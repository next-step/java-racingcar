package racingCar;

import racingCar.ui.InputView;
import racingCar.ui.ResultView;

import java.util.ArrayList;

public class RacingCarGame { // 자동차 경주를 수행한다.

	public void run() {
		// 입력받는다.
		InputView inputView = new InputView();
		GameRequest gameRequest = inputView.gameRequest();

		ResultView.printPrefix();

		Cars carList = new Cars(new ArrayList<>());
		carList.addCar(gameRequest.carCount());
		carList.moveByTryCount(gameRequest.tryCount());

	}

}
