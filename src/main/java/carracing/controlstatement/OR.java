package carracing.controlstatement;

public class OR extends Boolean {
	private final Boolean aBoolean;
	private final Boolean bBoolean;

	public OR(Boolean aBoolean, Boolean bBoolean) {
		this.aBoolean = aBoolean;
		this.bBoolean = bBoolean;
	}

	@Override
	public boolean booleanValue() {
		return this.aBoolean.booleanValue() || this.bBoolean.booleanValue();
	}
}
