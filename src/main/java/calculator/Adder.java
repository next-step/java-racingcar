package calculator;

public final class Adder {
	public int sumInts(int[] parsedNumbers) {
		int sum = 0;
		for (int parsedNumber : parsedNumbers) {
			sum += parsedNumber;
		}
		return sum;
	}
}
