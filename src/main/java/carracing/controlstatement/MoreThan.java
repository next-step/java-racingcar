package carracing.controlstatement;

public class MoreThan extends Boolean {
	private final int left;
	private final int right;

	public MoreThan(int left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean value() {
		return left >= right;
	}
}
