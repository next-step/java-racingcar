package step2;

public class StringCalculator {

	public int calculate(String input) {
		String[] parseResult = InterfaceUtil.parseInput(input);
		Operator operator = new Operator(Integer.parseInt(parseResult[0]));
		for (int i = 1; i < parseResult.length - 1; i += 2) {
			operator.operate(parseResult[i], Integer.parseInt(parseResult[i + 1]));
		}
		return operator.getSum();
	}

}