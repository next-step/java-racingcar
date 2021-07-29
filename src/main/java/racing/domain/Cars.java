package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {

	private final List<Car> cars = new ArrayList<>();

	public Cars(String carsName) {
		String[] carsNameArray = stringToSplit(carsName);
		for (String carName : carsNameArray) {
			Car car = new Car(carName);
			cars.add(car);
		}
	}

	private String[] stringToSplit(String carsName) {
		return carsName.split(",");
	}

	public Cars(Car... carArray) {
		cars.addAll(Arrays.asList(carArray));
	}

	public List<Car> getInformation() {
		return Collections.unmodifiableList(cars);
	}

	public Cars racing(RandomMoving randomMoving) {
		for (Car car : cars) {
			car.move(randomMoving.movable());
		}
		return this;
	}

	public int maxPosition() {
		return cars.stream()
			.mapToInt(Car::printPosition)
			.filter(car -> car >= 0)
			.max()
			.orElse(0);
	}

	public List<Car> winnerCars() {
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			searchWinner(winners, car);
		}
		return winners;
	}

	private void searchWinner(List<Car> winners, Car car) {
		if (car.isWinner(maxPosition())) {
			winners.add(car);
		}
	}
}
