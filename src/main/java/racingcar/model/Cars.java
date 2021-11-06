package racingcar.model;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import racingcar.rule.MoveRule;
import racingcar.util.StringUtils;

public class Cars {
	public static final String NAME_OF_CARS_DELIMITER = ",";

	private final List<Car> cars;

	Cars(List<Car> cars) {
		this.cars = new ArrayList<>(cars);
	}

	public static Cars create(List<Car> cars) {
		return new Cars(cars);
	}

	public static Cars create(String nameOfCars) {
		validate(nameOfCars);
		return createCarsFromNames(nameOfCars);
	}

	private static void validate(String nameOfCars) {
		if (StringUtils.isEmpty(nameOfCars)) {
			throw new IllegalArgumentException("nameOfCars must not be empty");
		}
	}

	private static Cars createCarsFromNames(String nameOfCars) {
		List<Car> cars = new ArrayList<>();

		String[] names = nameOfCars.split(NAME_OF_CARS_DELIMITER);
		for (String name : names) {
			cars.add(Car.create(name));
		}

		return Cars.create(cars);
	}

	public void move(MoveRule moveRule) {
		cars.forEach(car -> car.move(moveRule));
	}

	public List<String> getCarNamesWithHighestPosition() {
		Car highestPositionCar = findHighestPositionCar();
		return findHighestPositionCarNames(highestPositionCar);
	}

	private Car findHighestPositionCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalStateException("등록된 차가 없습니다."));
	}

	private List<String> findHighestPositionCarNames(Car highestPositionCar) {
		return cars.stream()
			.filter(highestPositionCar::equalsPosition)
			.map(Car::getName)
			.collect(toList());
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Cars cars1 = (Cars)o;

		return Objects.equals(cars, cars1.cars);
	}

	@Override
	public int hashCode() {
		return cars != null ? cars.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Cars{" +
			"cars=" + cars +
			'}';
	}

}
