package carracing.util.controlstatement;

public class GreaterThan extends Boolean {
	private final int left;
	private final int right;

	public GreaterThan(int left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean booleanValue() {
		return left > right;
	}
}
