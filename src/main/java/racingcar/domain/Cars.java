package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	private final List<Car> cars;

	public Cars(List<String> names) {
		validateDuplicateName(names);
		List<Car> tempCars = new ArrayList<>();
		for (String name : names) {
			tempCars.add(new Car(name));
		}
		this.cars = tempCars;
	}

	private void validateDuplicateName(List<String> names) {
		Set<String> uniqueNames = new HashSet<>(names);
		if (uniqueNames.size() != names.size()) {
			throw new RuntimeException("중복된 자동차 이름이 존재합니다.");
		}
	}

	public void moveCars(MovingStrategy movingStrategy) {
		for (Car car : cars) {
			car.go(movingStrategy);
		}
	}

	public List<CarInfo> getCarsNameAndLocation() {
		return cars.stream()
			.map(CarInfo::new)
			.toList();
	}

}
