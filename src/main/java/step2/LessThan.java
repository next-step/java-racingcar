package step2;

public class LessThan extends Boolean {
	private final String left;
	private final int right;

	public LessThan(String left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean satisfied() {
		return Integer.parseInt(left) < right;
	}
}
