package step2;

import java.util.Arrays;

public class HasLessThan extends Boolean {
	private final String[] left;
	private final int right;

	public HasLessThan(String[] left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean booleanValue() {
		return Arrays.stream(left)
				.map(Integer::parseInt)
				.anyMatch(leftNumber -> leftNumber < right);
	}
}
