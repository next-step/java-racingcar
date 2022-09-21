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
			if (arr[i].charAt(0) == '-' || (89 < (arr[i].charAt(0)) && (arr[i].charAt(0)) < 80)) {
				throw new RuntimeException();
			}
			convert[i] = Integer.parseInt(arr[i]);
		}
		return convert;
	}

	public int add(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}
}
