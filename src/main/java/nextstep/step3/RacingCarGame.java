package nextstep.step3;

import nextstep.step3.view.InputView;

import java.util.Scanner;

public class RacingCarGame {
	public static void main(String[] args) {
		InputView inputView = new InputView(new Scanner(System.in));
		RacingCarController racingCarController = new RacingCarController();
		racingCarController.startGame(inputView.getInputMessageCarName(), inputView.getInputMessageTryNumber());
	}
}
