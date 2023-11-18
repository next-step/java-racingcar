package carracing.util.controlstatement;

public class LessThan extends Boolean {
	private final int left;
	private final int right;

	public LessThan(int left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean booleanValue() {
		return left < right;
	}
}
