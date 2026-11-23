package racingcar.domain.game;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.car.Car;

public class RacingResult {

	private final List<CarResult> carResults = new ArrayList<>();


	public RacingResult(List<Car> cars) {
		for (Car car : cars) {
			carResults.add(new CarResult(car.getName(), car.getPosition()));
		}
	}

	public List<CarResult> getCarResults() {
		return carResults;
	}
}
