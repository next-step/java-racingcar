package carRacing.level3;

import carRacing.level3.model.strategy.MovingStrategy;

public class FixMovingStrategy implements MovingStrategy {

	private final int PIVOT = 4;
	private final int BOUNDARY = 10;
	private final int FIXNUM = 5;


	@Override
	public Boolean isMovable() {

		if (FIXNUM >= PIVOT && FIXNUM < BOUNDARY) {
			return true;
		}
		return false;
	}

}

