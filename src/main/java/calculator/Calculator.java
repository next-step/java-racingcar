package calculator;

public class Calculator {

	public String calculate(String input) {
		if ( (input == null) || (input.isEmpty()) ) {
			return "0";
		}

		return input;
	}

}
