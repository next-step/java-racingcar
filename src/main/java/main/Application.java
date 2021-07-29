package main;

import calculator.Calculator;
import calculator.CalculcatorUI;

public class Application {
	public static void main(String[] args) {
		// 계산기 게임
		Calculator calculator = new Calculator();
		CalculcatorUI.printIntro();
		int result = calculator.calculate(CalculcatorUI.getInput());
		CalculcatorUI.printResult(result);
	}
}
