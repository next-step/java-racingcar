package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars = new ArrayList<>();

	public Cars(String[] cars) {
		for (String carName : cars) {
			this.cars.add(new Car(carName));
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Car> findWinner() {
		return findWinners(findWinnerPosition(), getCars());
	}

	private int findWinnerPosition() {
		int max = 0;
		for (int i = 0; i < cars.size(); i++) {
			max = Math.max(max, cars.get(i).getStatus().getPosition());
		}
		return max;
	}

	private List<Car> findWinners(int max, List<Car> winners) {
		List<Car> classify = winners.stream()
			.filter(car -> car.getStatus().getPosition() == max)
			.collect(Collectors.toList());
		return classify;
	}
}
