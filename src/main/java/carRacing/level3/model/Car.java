package carRacing.level3.model;

import carRacing.level3.model.strategy.MovingStrategy;
import carRacing.level3.view.output.OutPutView;

public class Car {

	private static final Integer DEFAULT_LOCATION = 0;
	private static final Integer MOVE_LOCATION = 1;
	private Integer location;

	public Car() {
		this.location = DEFAULT_LOCATION;
	}

	public int carLocation() {
		return location;
	}

	public void moveLocation(MovingStrategy strategy) {
		if (strategy.isMovable()) {
			location += MOVE_LOCATION;
		}
	}
}
