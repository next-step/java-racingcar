package study.racingcar.controller;

import java.util.Scanner;

import study.racingcar.domain.RacingGame;
import study.racingcar.domain.UserChoice;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class GameController {

	private GameController() {
		throw new AssertionError();
	}

	public static void start() {

		RacingGame status = readyToGame();
		printStart();
		status.playGame();

	}

	private static RacingGame readyToGame() {
		UserChoice userChoice = inputUserChoice();
		return new RacingGame(userChoice);
	}

	private static UserChoice inputUserChoice() {
		Scanner scanner = new Scanner(System.in);

		int carCount = InputView.inputCarCountByUser(scanner);
		int gameRounds = InputView.inputGameRoundByUser(scanner);

		return new UserChoice(carCount, gameRounds);
	}

	private static void printStart() {
		ResultView.printStart();
	}

}
