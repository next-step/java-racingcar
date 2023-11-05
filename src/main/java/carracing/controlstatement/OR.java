package carracing.controlstatement;

public class OR extends Boolean {
	private final LessThan lessThan;
	private final GreaterThan greaterThan;

	public OR(LessThan lessThan, GreaterThan greaterThan) {
		this.lessThan = lessThan;
		this.greaterThan = greaterThan;
	}

	@Override
	public boolean booleanValue() {
		return this.lessThan.booleanValue() || this.greaterThan.booleanValue();
	}
}
