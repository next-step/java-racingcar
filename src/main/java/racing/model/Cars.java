package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> cars = new ArrayList<>();

	public Cars(List<Name> names) {
		if (names == null) {
			throw new IllegalArgumentException("자동차를 생성할 수 없습니다.");
		}
		generateCars(names);
	}

	private void generateCars(List<Name> names) {
		for (Name name : names) {
			cars.add(new Car(name));
		}
	}

	public List<Car> getWinners() {
		return chooseWinners(getMaxPosition());
	}

	private Position getMaxPosition() {
		return cars.stream().map(Car::getPosition).max(Position::compareTo).orElse(Position.ZERO);
	}

	private List<Car> chooseWinners(Position maxPosition) {
		return cars.stream().filter(car -> car.isSamePosition(maxPosition)).collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return cars;
	}
}
