package carracing.domain.game;

import carracing.domain.car.Cars;
import carracing.domain.car.Winners;

public class MaxMoving implements WinnerStrategy {
	@Override
	public Winners winners(Cars cars) {
		int maxMovingDistance = maxMovingDistance(cars);
		Cars winners = winnersWithMaxMovingDistance(cars, maxMovingDistance);

		return new Winners(winners);
	}

	private int maxMovingDistance(Cars cars) {
		return cars.maxMovingDistance();
	}

	private Cars winnersWithMaxMovingDistance(Cars cars, int maxMovingDistance) {
		return cars.winnersWithMaxMovingDistance(maxMovingDistance);
	}
}
