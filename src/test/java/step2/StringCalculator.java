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

	public int[] convertToInt(String[] arr) {
		int[] convert = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			convert[i] = Integer.parseInt(arr[i]);
		}
		return convert;
	}
}
