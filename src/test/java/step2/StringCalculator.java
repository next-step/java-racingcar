package step2;

public class StringCalculator {
	public int calculate(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		return 0;
	}

	public String[] split(String input) {
		String separators = ",|:";
		return input.split(separators);
	}
}
