package step3_racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step3_racingcar.domain.Car;

public class GameProcess {

	public List<List<Car>> play(int tryCount, List<Car> cars) {
		List<List<Car>> results = new ArrayList<>();

		for (int i = 0; i < tryCount; i++) {
			playRound(cars);
			results.add(cloneCars(cars));
		}

		return results;
	}

	private void playRound(List<Car> cars) {
		for (Car car : cars) {
			car.tryMove();
		}
	}

	private List<Car> cloneCars(List<Car> cars) {
		return cars.stream()
			.map(Car::clone)
			.collect(Collectors.toList());
	}
}
