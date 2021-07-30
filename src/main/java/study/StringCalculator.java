package study;


public class StringCalculator {

	public int calculate(String str) {

		if(str == null || str.equals("")) {
			throw new IllegalArgumentException();
		}

		String[] strArray = str.split(" ");
		int result = Integer.parseInt(strArray[0]);

		for(int i = 1 ; i < strArray.length ; ++i) {
			if(i % 2 == 0) {
				result = getMiddleResult(strArray[i-1], result, Integer.parseInt(strArray[i]));
			}
		}

		return result;
	}

	private int getMiddleResult(String param, int middleValue, int target) {
		if(param.equals("+")) {
			return middleValue + target;
		}
		if(param.equals("-")) {
			return middleValue - target;
		}
		if(param.equals("*")) {
			return middleValue * target;
		}
		if(param.equals("/")) {
			return middleValue / target;
		}
		throw new IllegalArgumentException();
	}
}
