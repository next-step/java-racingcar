package carRacing.level3.domain;

import carRacing.level3.service.MovingStrategy;
import carRacing.level3.service.output.OutPutView;

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
		if (strategy.getMovement()) {
			location += MOVE_LOCATION;
		}
	}
	public void showMovement(OutPutView outPutView){
		outPutView.showCar(carLocation());
	}

}
