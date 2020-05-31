package study4.controller;

import java.util.List;
import java.util.Scanner;

import study4.domain.RacingGame;
import study4.domain.Winner;
import study4.view.InputView;
import study4.view.ResultView;

public class RacingMain {
	
	
	public static void main(String[] args) {
		
		InputView inputview;
		ResultView resultview;
		Winner winner = new Winner();
		
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
