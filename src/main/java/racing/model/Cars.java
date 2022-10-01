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

	private Position getMaxPosition() {
		return cars.stream().map(Car::getPosition).max(Position::compareTo).orElse(Position.ZERO);
	}

	private void chooseWinners(List<Name> winners, Position maxPosition) {
		for (Car car : cars) {
			if (isWinner(car.getPosition(), maxPosition)) {
				winners.add(car.getName());
			}
		}
	}

	private boolean isWinner(Position position, Position maxPosition) {
		return position.equals(maxPosition);
	}
}
