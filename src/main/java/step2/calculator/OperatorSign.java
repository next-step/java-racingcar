package step2.calculator;

import java.util.Arrays;

public enum OperatorSign {
	PLUS("+"), MINUS("-");

	private final String sign;

	OperatorSign(final String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return sign;
	}

	public boolean equals(final String sign) {
		return this.sign.equals(sign);
	}

	public static boolean isSign(final String input) {
		return Arrays.stream(OperatorSign.values())
			.anyMatch(operatorSign -> operatorSign.equals(input));
	}
}
