package racing.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Name> getWinners() {
		return chooseWinners(getMaxPosition());
	}

	private Position getMaxPosition() {
		return cars.stream().map(Car::getPosition).max(Position::compareTo).orElse(Position.ZERO);
	}

	private List<Name> chooseWinners(Position maxPosition) {
		return cars.stream().filter(car -> car.isWinner(maxPosition)).map(Car::getName).collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return cars;
	}
}
