package step1;

public enum ScaleRule {

	FINAL_RESULT(4),
	DIVIDEND(8);

	private final int scale;

	ScaleRule(int scale) {
		this.scale = scale;
	}

	public int getScale() {
		return this.scale;
	}

}
