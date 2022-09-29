package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Racing {

	private List<Car> cars;

	public Racing(int carCount) {
		generateCars(carCount);
	}

	private void generateCars(int carCount) {
		this.cars = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car());
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
