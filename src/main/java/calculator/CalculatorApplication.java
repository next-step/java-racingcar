package calculator;

import java.util.Scanner;

public class CalculatorApplication {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		while (true) {
			playCalculator(userInput);
		}
	}

	private static void playCalculator(Scanner userInput) {
		System.out.print("연산을 입력하세요: ");
		String userInputCalculationExpression = userInput.nextLine();
		try {
			CalculationFactory calculationFactory = new CalculationExpressionFactory();
			CalculationExpression expression = calculationFactory.calculationExpressionParser(userInputCalculationExpression);
			expression.executeAll();
			System.out.println(expression.getResult().valueOfFactor());
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
