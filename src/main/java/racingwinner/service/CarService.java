package racingwinner.service;

import racingwinner.domain.Car;

import java.util.*;

public class CarService {

	private final List<Car> cars = new ArrayList<>();
	private final Set<String> winners = new HashSet<>();
	private int winnerCount;

	public CarService(String[] carNames) {
		for (String carName : carNames) {
			this.cars.add(new Car(carName.trim()));
		}
	}

	public List<Car> moveCars() {
		for (Car car : cars) {
			car.moveForward();
		}
		return cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public Set<String> selectWinners() {
		updateWinnerCount();
		for (Car car : cars) {
			addWinner(car);
		}
		return winners;
	}

	private void updateWinnerCount() {
		winnerCount = cars.stream()
		                  .max(Comparator.comparing(Car::getForwardCount))
		                  .orElseGet(() -> new Car(""))
		                  .getForwardCount();
	}

	private void addWinner(Car car) {
		if (car.getForwardCount() == winnerCount) {
			winners.add(car.getName());
		}
	}

}
