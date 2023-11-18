package carracing.util.controlstatement;

public class IF extends Boolean {
	private final Boolean aBoolean;

	public IF(Boolean aBoolean) {
		this.aBoolean = aBoolean;
	}

	@Override
	public boolean booleanValue() {
		return aBoolean.booleanValue();
	}
}
