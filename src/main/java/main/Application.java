package main;

import java.util.List;

import calculator.Calculator;
import calculator.CalculcatorUI;
import carrase.CarRasingGame;
import carrase.CarRasingGameUI;

public class Application {
	public static void main(String[] args) {
		// 계산기 게임
		// Calculator calculator = new Calculator();
		// CalculcatorUI.printIntro();
		// int result = calculator.calculate(CalculcatorUI.getInput());
		// CalculcatorUI.printResult(result);


		// 레이싱 게임
		CarRasingGameUI ui = new CarRasingGameUI();
		ui.start();
	}
}
