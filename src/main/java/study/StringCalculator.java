package study;

public class StringCalculator {

	public Integer plus(String str) {
		String[] stringArray = str.split(" ");
		return Integer.parseInt(stringArray[0]) + Integer.parseInt(stringArray[2]);
	}

	public Integer minus(String str) {
		String[] stringArray = str.split(" ");
		return Integer.parseInt(stringArray[0]) - Integer.parseInt(stringArray[2]);
	}

	public Integer multiply(String str) {
		String[] stringArray = str.split(" ");
		return Integer.parseInt(stringArray[0]) * Integer.parseInt(stringArray[2]);
	}

	public Integer divide(String str) {
		String[] stringArray = str.split(" ");
		return Integer.parseInt(stringArray[0]) / Integer.parseInt(stringArray[2]);
	}
}
