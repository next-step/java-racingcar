package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
	private static final Random RANDOM = new Random();
	private List<Car> cars = new ArrayList<>();

	public static Cars createCars(final String[] carNames) {
		Cars cars = new Cars();
		for (String carName : carNames) {
			cars.addCar(Car.createCar(new Name(carName)));
		}
		return cars;
	}

	private void addCar(final Car car) {
		cars.add(car);
	}

	public void moveCars() {
		for (Car car : cars) {
			car.move(RANDOM.nextInt(10));
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public Integer getSize() {
		return cars.size();
	}

	public void add(final Car car) {
		cars.add(car);
	}

	public List<String> getWinnerCarNames() {
		int maxPosition = cars.stream()
				.max(Comparator.comparing(Car::getPositionNumber))
				.orElseThrow(IllegalArgumentException::new)
				.getPositionNumber();
		return cars.stream()
				.filter(car -> car.getPositionNumber() == maxPosition)
				.map(car -> car.getName().getName())
				.collect(Collectors.toList());
	}
}
