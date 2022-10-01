package racing.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getWinners() {
		return chooseWinners(getMaxPosition());
	}

	private Position getMaxPosition() {
		return cars.stream().map(Car::getPosition).max(Position::compareTo).orElse(Position.ZERO);
	}

	private List<Car> chooseWinners(Position maxPosition) {
		return cars.stream().filter(car -> car.isWinner(maxPosition)).collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return cars;
	}
}
