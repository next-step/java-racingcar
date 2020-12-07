package study.calculator;

public class Application {
	public static void main(String[] args) {
		Operators operators = new Operators();
		Calculator calculator = new Calculator(operators);

		calculator.powerOn();
	}
}
