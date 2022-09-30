package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private List<Car> cars = new ArrayList<>();

	public Cars(List<Name> names) {
		for (Name name : names) {
			cars.add(new Car(name));
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<String> getWinners() {
		List<String> winners = new ArrayList<>();
		chooseWinners(winners, getMaxPosition());
		return winners;
	}

	private int getMaxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
		return maxPosition;
	}

	private void chooseWinners(List<String> winners, int maxPosition) {
		for (Car car : cars) {
			if (isWinner(car, maxPosition)) {
				winners.add(car.getName());
			}
		}
	}

	private boolean isWinner(Car car, int maxPosition) {
		return car.getPosition() == maxPosition;
	}
}
