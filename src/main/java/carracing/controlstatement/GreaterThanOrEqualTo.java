package carracing.controlstatement;

public class GreaterThanOrEqualTo extends Boolean {
	private final int left;
	private final int right;

	public GreaterThanOrEqualTo(int left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean booleanValue() {
		return left >= right;
	}
}
