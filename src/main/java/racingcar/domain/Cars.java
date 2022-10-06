package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public void move(int random) {
		for (Car car : cars) {
			car.movingOfRound(random);
		}
	}

	public List<Car> findWinner() {
		return findWinners(findWinnerPosition(), getCars());
	}

	private int findWinnerPosition() {
		int max = 0;
		for (int i = 0; i < cars.size(); i++) {
			max = Math.max(max, cars.get(i).takePosition());
		}
		return max;
	}

	private List<Car> findWinners(int max, List<Car> winners) {
		return winners.stream()
			.filter(car -> car.hasSamePosition(max))
			.collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return cars;
	}
}
