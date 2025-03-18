package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(String namesInput) {
		String[] names = namesInput.split(",");
		List<Car> tempCars = new ArrayList<>();
		for (String name : names) {
			tempCars.add(new Car(name.trim()));
		}
		this.cars = tempCars;
	}

	public void moveCars(MovingStrategy movingStrategy) {
		for (Car car : cars) {
			car.go(movingStrategy);
		}
	}

	public List<Integer> getCarsLocation() {
		return cars.stream()
			.map(Car::getLocation)
			.toList();
	}

	public List<CarInfo> getCarsNameAndLocation() {
		return cars.stream()
			.map(CarInfo::new)
			.toList();
	}

	public int getMaxLocation() {
		return cars.stream()
			.mapToInt(Car::getLocation)
			.max()
			.orElseThrow(() -> new RuntimeException("자동차가 존재하지 않습니다."));
	}

	public List<String> getWinners() {
		int maxLocation = getMaxLocation();
		return cars.stream()
			.filter(car -> car.getLocation() == maxLocation)
			.map(Car::getName)
			.toList();
	}

}
