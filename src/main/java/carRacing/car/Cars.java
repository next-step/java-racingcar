package carRacing.car;

import carRacing.moveStrategy.MoveStrategy;
import java.util.ArrayList;
import java.util.List;

public class Cars {

	private List<Car> cars = new ArrayList<>();

	public Cars(List<String> carNames) {
		makeCars(carNames);
	}

	private List<Car> makeCars(List<String> carNames) {
		for (int i = 0; i < carNames.size(); i++) {
			cars.add(new Car(0, carNames.get(i)));
		}
		return cars;
	}

	public void moveCars(MoveStrategy moveStrategy) {
		for (Car car : cars) {
			car.moveCar(moveStrategy);
		}
	}

	public List<Car> getCars() {
		return cars;
	}
}
