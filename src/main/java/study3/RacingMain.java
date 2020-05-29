package study3;

import java.util.List;
import java.util.Scanner;

public class RacingMain {
	public static void main(String[] args) {

		InputView inputview;
		ResultView resultview;

		inputview = new InputView(); // Racing Input
		int carNum = inputview.carInputMessages();
		int carTrial = inputview.trialInputMessages();

		RacingGame rg = new RacingGame(carNum, carTrial); // Racing validation
		List carList = rg.carParkinglot(carNum); // Racing 개수 생성

		resultview = new ResultView(); // Racing Result

		for (int i = 0; i < carTrial; i++) { // 자동차 출력
			resultview.outputResult(rg.racingcarMove(carList));
		}

	}
}
