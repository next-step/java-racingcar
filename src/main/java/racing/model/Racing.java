package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Racing {

	private List<Car> cars;

	public Racing(List<Name> names) {
		generateCars(names);
	}

	private void generateCars(List<Name> names) {
		this.cars = new ArrayList<>();
		for (Name name : names) {
			cars.add(new Car(name));
		}
	}

	public List<Position> race(MoveStrategy moveStrategy) {
		List<Position> result = new ArrayList<>();
		for (Car car : cars) {
			result.add(car.move(moveStrategy.isMovable()));
		}
		return result;
	}

	public List<Car> getCars() {
		return cars;
	}
}
