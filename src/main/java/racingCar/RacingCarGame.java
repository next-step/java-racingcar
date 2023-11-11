package racingCar;

import racingCar.ui.InputView;
import racingCar.ui.ResultView;

import java.util.ArrayList;

public class RacingCarGame { // 자동차 경주를 수행한다.

	public void run() {
		// 입력받는다.
		InputView.takeInputFromUser();
		int carCount = InputView.carCount;
		int tryCount = InputView.tryCount;

		System.out.println();
		System.out.println(ResultView.RESULT_PREFIX);

		CarList carList = new CarList(new ArrayList<>());
		carList.addCar(carCount);
		carList.moveByTryCount(tryCount);
	}

}
