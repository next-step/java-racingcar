package study.calculator;

public class Calculator {
	private InputScanner inputScanner = new InputScanner();
	private final Operators operators;

	public Calculator(Operators operators) {
		this.operators = operators;
	}

	public void powerOn() {
		String input = inputScanner.scan();
		int result = calculateInput(input);
		System.out.println("결과는 " + result + " 입니다.");

	}

	public int calculateInput(String input) {
		String trim = input.trim();
		String[] split = trim.split(" ");

		int temp = Integer.parseInt(split[0]);

		for (int i = 1; i < split.length; i += 2) {
			temp = operators.calculate(OperatorStatus.mapOperatorStatus(split[i]), temp,
				Integer.parseInt(split[i + 1]));
		}

		return temp;
	}
}
