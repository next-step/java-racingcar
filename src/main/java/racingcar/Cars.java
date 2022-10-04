package racingcar;

import java.util.ArrayList;
import java.util.List;

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
		int max = 0;
		List<Car> winners = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			max = bestPosition(max, i);
		}
		return findWinners(max, winners);
	}

	private List<Car> findWinners(int max, List<Car> winners) {
		for (Car car : cars) {
			if (car.getStatus().getPosition() == max) {
				winners.add(car);
			}
		}
		return winners;
	}

	private int bestPosition(int max, int i) {
		if (max <= cars.get(i).getStatus().getPosition()) {
			max = cars.get(i).getStatus().getPosition();
		}
		return max;
	}
}
