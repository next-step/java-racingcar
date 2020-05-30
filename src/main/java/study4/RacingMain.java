package study4;

import java.util.List;
import java.util.Scanner;

public class RacingMain {
	// 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
	// 위 규칙 적용을 위해 객체 선언을 main메소드 밖으로 빼고 static으로 선언해도 괜찮나요?

	static InputView inputview;
	static ResultView resultview;
	static Winner winner = new Winner();

	public static void main(String[] args) {

		inputview = new InputView(); // Racing Input
		String carName = inputview.carInputMessages();
		int carTrial = inputview.trialInputMessages();

		RacingGame rg = new RacingGame(carName, carTrial); // Racing validation
		List carList = rg.splitCarName(carName); // 자동차 개수 생성

		resultview = new ResultView(); // Racing Result

		for (int i = 0; i < carTrial; i++) { // 자동차 출력
			carList = resultview.outputResult(rg.racingcarMove(carList));
		}
		// 우승자 출력
		winner.winnerMaxPosition(carList);
	}
}
