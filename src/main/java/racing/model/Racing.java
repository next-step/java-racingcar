package racing.model;

import racing.dto.RacingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

	private final Cars cars;

	public Racing(List<Name> names) {
		cars = new Cars(generateCars(names));
	}

	private List<Car> generateCars(List<Name> names) {
		List<Car> cars = new ArrayList<>();
		for (Name name : names) {
			cars.add(new Car(name));
		}
		return cars;
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
		List<Car> winners = cars.getWinners();
		return winners.stream().map(Car::getName).map(Name::getName).collect(Collectors.toList());
	}
}
