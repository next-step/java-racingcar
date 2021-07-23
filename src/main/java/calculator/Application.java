package calculator;

public class Application {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		CalculcatorUI.printIntro();
		int result = calculator.calculate(CalculcatorUI.getInput());
		CalculcatorUI.printResult(result);
	}
}
