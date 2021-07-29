package refactoring.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import strategy.Moveable;

public class Cars {

	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars of(String carNames) {
		String[] names = carNames.split(",");

		List<Car> cars = Arrays.stream(names)
							   .map(Car::new)
					   		   .collect(Collectors.toList());
		return new Cars(cars);
	}

	public List<Car> getWinner() {
		return cars.stream()
				   .filter(car -> car.sameWinnerCarDistance(getMaxDistance()))
				   .collect(Collectors.toList());
	}

	public void move(Moveable moveable) {
		for (Car car : cars) {
			car.move(moveable);
		}
	}

	private Car getMaxDistance() {
		return cars.stream()
				   .max(Comparator.comparingInt(Car::getCarDistance))
				   .orElseThrow(IndexOutOfBoundsException::new);
	}
}
