package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public void move(int random, int index) {
		cars.get(index).movingOfRound(random);
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

	public String getCarName(int index) {
		return cars.get(index).takeName();
	}

	public int getCarPosition(int index) {
		return cars.get(index).takePosition();
	}

	public List<Car> getCars() {
		return cars;
	}
}
