package racingwinner.service;

import racingwinner.domain.Car;

import java.util.*;

public class CarWinners {

	private static final Set<String> winners = new HashSet<>();
	private static int winnerCount;

	private CarWinners() {
		throw new IllegalStateException();
	}

	public static Set<String> selectWinners(List<Car> cars) {
		updateWinnerCount(cars);
		for (Car car : cars) {
			addWinner(car);
		}
		return winners;
	}

	private static void updateWinnerCount(List<Car> cars) {
		winnerCount = cars.stream()
		                  .max(Comparator.comparing(Car::getForwardCount))
		                  .orElseGet(() -> new Car(""))
		                  .getForwardCount();
	}

	private static void addWinner(Car car) {
		if (car.getForwardCount() == winnerCount) {
			winners.add(car.getName());
		}
	}

}
