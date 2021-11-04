package calculation;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Number {
	private static final String NUMBER_PATTERN = "^[0-9]*$";
	private final int[] number;

	public Number(String[] formula) {
		this.number = changeToStringInteger(formula);
	}

	private int[] changeToStringInteger(String[] formula) {
		return Arrays.stream(numberSeparation(formula))
			.mapToInt(Integer::parseInt)
			.toArray();
	}

	private String[] numberSeparation(String[] formula){
		return Arrays.stream(formula)
			.filter(i -> Pattern.matches(NUMBER_PATTERN, i))
			.toArray(String[]::new);
	}

	public int firstNumber(int calculationValue, int index){
		if(calculationValue == 0){
			return number[index];
		}

		return calculationValue;
	}

	public int value(int index) {
		return number[index];
	}
}
