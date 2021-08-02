package main;

import java.util.List;

import calculator.Calculator;
import calculator.CalculcatorUI;
import carrase.CarRacingGame;
import carrase.CarRacingGameUI;

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
		CarRacingGameUI ui = new CarRacingGameUI();

		ui.printQuestionOfCarCount();
		CarRacingGame game = new CarRacingGame(ui.getInput());
		ui.printQuestionOfGameCount();

		int countOfGame = ui.getInput();

		ui.printMessageOfGameResult();
		for(int i = 0; i < countOfGame; i++) {
			List<Integer> result = game.start();
			ui.printResult(result);
		}
	}
}
