package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars extends Condition {
	private List<Car> cars = new ArrayList<>();

	public Cars(String[] cars) {
		super(new NameCondition());
		for (String carName : cars) {
			validName(carName);
		}
	}

	private void validName(String carName) {
		if (validInput(carName)) {
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
			if (car.getStatus() == max) {
				winners.add(car);
			}
		}
		return winners;
	}

	private int bestPosition(int max, int i) {
		if (max <= cars.get(i).getStatus()) {
			max = cars.get(i).getStatus();
		}
		return max;
	}
}
