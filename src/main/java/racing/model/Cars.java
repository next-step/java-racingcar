package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> cars = new ArrayList<>();

	public Cars(List<Name> names) {
		for (Name name : names) {
			cars.add(new Car(name));
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<String> getWinners() {
		List<Name> winners = new ArrayList<>();
		chooseWinners(winners, getMaxPosition());
		return winners.stream().map(Name::getName).collect(Collectors.toList());
	}

	private int getMaxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = comparePosition(maxPosition, car.getPosition());
		}
		return maxPosition;
	}

	private int comparePosition(int maxPosition, Position position) {
		return Math.max(maxPosition, position.getPosition());
	}

	private void chooseWinners(List<Name> winners, int maxPosition) {
		for (Car car : cars) {
			if (isWinner(car.getPosition(), maxPosition)) {
				winners.add(car.getName());
			}
		}
	}

	private boolean isWinner(Position position, int maxPosition) {
		return position.getPosition() == maxPosition;
	}
}
