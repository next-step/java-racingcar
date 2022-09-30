package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Racing {

	private final Cars cars;

	public Racing(List<Name> names) {
		cars = generateCars(names);
	}

	private Cars generateCars(List<Name> names) {
		return new Cars(names);
	}

	public List<Result> race(MoveStrategy moveStrategy) {
		List<Result> result = new ArrayList<>();
		for (Car car : cars.getCars()) {
			car.move(moveStrategy.isMovable());
			result.add(new Result(car.getPosition(), car.getName()));
		}
		return result;
	}

	public Cars getCars() {
		return cars;
	}

	public List<String> getWinners() {
		return cars.getWinners();
	}
}
