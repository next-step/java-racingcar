package main;

import calculator.Calculator;
import calculator.CalculcatorUI;
import carrase.CarRacingGame;
import carrase.InputView;
import carrase.ResultView;

public class Application {
	public static void main(String[] args) {
		Application app = new Application();
		// 계산기
		//app.runCalculator();

		// 레이싱 게임
		app.runRacingGame();
	}

	private void runCalculator() {
		Calculator calculator = new Calculator();
		CalculcatorUI.printIntro();
		int result = calculator.calculate(CalculcatorUI.getInput());
		CalculcatorUI.printResult(result);
	}

	private void runRacingGame() {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		inputView.drawQuestionOfCarNames();
		CarRacingGame game = new CarRacingGame(inputView.getCarNames());
		inputView.drawQuestionOfGameCount();
		int countOfGame = inputView.getGameCount();

		resultView.drawMessageOfGameResult();
		for(int i = 0; i < countOfGame; i++) {
			game.start();
			resultView.drawTotalResult(game.getGameResult());
		}
		resultView.drawWinner(game.getCarGameWinner());
	}
}
