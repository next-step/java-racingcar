package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import racingcar.strategy.MoveStrategy;

public class Cars {

	private static final String DELIMITER = ",";

	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars of(String carNames) {
		List<Car> cars = new ArrayList<>();
		String[] names = carNames.split(DELIMITER);
		for (String name : names) {
			cars.add(new Car(new CarName(name)));
		}
		return new Cars(cars);
	}

	public static Cars of(List<Car> cars) {
		return new Cars(cars);
	}

	public void move(MoveStrategy moveStrategy) {
		for (Car car : cars) {
			car.move(moveStrategy);
		}
	}

	public RaceWinners findRaceWinners() {
		Car carLocatedAtMaxPosition = findCarLocatedAtMaxPosition();
		List<Car> winners = cars.stream()
								.filter(car -> car.hasSamePositionWith(carLocatedAtMaxPosition))
								.collect(Collectors.toList());

		return new RaceWinners(Collections.unmodifiableList(winners));
	}

	private Car findCarLocatedAtMaxPosition() {
		return cars.stream()
			.max(Comparator.comparingInt(Car::getCarPosition))
			.orElseThrow(NoSuchElementException::new);
	}

	public List<Car> cars() {
		return cars;
	}

}
