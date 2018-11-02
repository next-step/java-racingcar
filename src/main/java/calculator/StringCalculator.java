package calculator;

/**
 * Created by hspark on 02/11/2018.
 */
public class StringCalculator {
	public int calculate(String text) {
		String[] values = text.split(" ");

		int result = Integer.parseInt(values[0]);
		for (int i = 1; i < values.length - 1; i += 2) {
			Operator operator = Operator.findOperator(values[i]);
			int number = Integer.parseInt(values[i + 1]);
			result = operator.calculate(result, number);
		}

		return result;
	}
}
