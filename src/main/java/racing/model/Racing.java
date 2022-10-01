package racing.model;

import racing.dto.RacingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

	private final Cars cars;

	public Racing(List<Name> names) {
		cars = generateCars(names);
	}

	private Cars generateCars(List<Name> names) {
		return new Cars(names);
	}

	public List<RacingResult> race(MoveStrategy moveStrategy) {
		List<RacingResult> result = new ArrayList<>();
		for (Car car : cars.getCars()) {
			car.move(moveStrategy.isMovable());
			result.add(new RacingResult(car.getPosition(), car.getName()));
		}
		return result;
	}

	public Cars getCars() {
		return cars;
	}

	public List<String> getWinners() {
		List<Name> winners = cars.getWinners();
		return winners.stream().map(Name::getName).collect(Collectors.toList());
	}
}
