package study.calculator;

public class Calculator {
	private final InputScanner inputScanner = new InputScanner();

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
			Operators operator = Operators.mapOperatorStatus(split[i]);

			temp = operator.calculate(temp, Integer.parseInt(split[i + 1]));
		}

		return temp;
	}
}
