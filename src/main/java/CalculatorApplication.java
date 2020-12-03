import java.util.Scanner;

import calculator.Calculation;
import calculator.CalculationExpressionFactory;
import calculator.CalculationFactory;

public class CalculatorApplication {

	private static final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		CalculationFactory calculationFactory = new CalculationExpressionFactory();
		while (true) {
			playCalculator(calculationFactory);
		}
	}

	private static void playCalculator(CalculationFactory calculationFactory) {
		System.out.print("연산을 입력하세요: ");
		try {
			Calculation expression = calculationFactory.calculationExpressionParser(userInput.nextLine());
			System.out.println(expression.calculationResult());
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
