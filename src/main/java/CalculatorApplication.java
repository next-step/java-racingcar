import java.util.Scanner;

import calculator.Calculation;
import calculator.CalculationExpressionFactory;
import calculator.CalculationFactory;

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
			Calculation expression = calculationFactory.calculationExpressionParser(userInputCalculationExpression);
			System.out.println(expression.calculationResult());
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
