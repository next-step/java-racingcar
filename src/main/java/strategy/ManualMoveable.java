package strategy;

public class ManualMoveable implements Moveable {

	private static final boolean MOVEABLE = true;

	@Override
	public boolean isMoveable() {
		return MOVEABLE;
	}
}
