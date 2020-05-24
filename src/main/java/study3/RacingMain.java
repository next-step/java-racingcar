package study3;

import java.util.List;
import java.util.Scanner;

public class RacingMain {
	public static void main(String[] args) {

		InputView iv;
		ResultView rv;

		iv = new InputView(); // Racing Input
		int carNum = iv.carInputMessages();
		int carTrial = iv.trialInputMessages();

		RacingGame rg = new RacingGame(carNum, carTrial); // Racing validation
		List carList = rg.carParkinglot(carNum); // Racing 개수 생성

		rv = new ResultView(); // Racing Result

		for (int i = 0; i < carTrial; i++) { // 자동차 출력
			rv.outputResult(rg.racingcarMove(carList));
		}

	}
}
