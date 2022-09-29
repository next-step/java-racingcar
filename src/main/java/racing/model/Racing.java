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

	public void race(MoveStrategy moveStrategy) {
		for (Car car : cars) {
			car.move(moveStrategy.isMovable());
		}
	}

	public List<Car> getCars() {
		return cars;
	}
}
