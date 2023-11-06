package carracing.controlstatement;

public abstract class Boolean {
	public boolean isTrue() {
		return true;

	}

	public abstract boolean booleanValue();

	public static final class SmartTrue extends Boolean {
		@Override
		public boolean booleanValue() {
			return true;
		}
	}

	public static final class SmartFalse extends Boolean {
		@Override
		public boolean booleanValue() {
			return false;
		}
	}
}
