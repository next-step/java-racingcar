package step2;

import java.util.Arrays;

public class Sum extends Number {
	private final String[] inputs;

	public Sum(String[] inputs) {
		this.inputs = inputs;
	}

	@Override
	public int intValue() {
		return Arrays.stream(inputs)
				.map(Integer::parseInt)
				.reduce(0, Integer::sum);
	}
}
