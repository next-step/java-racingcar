package carRacing.domain;

import carRacing.strategy.MoveStrategy;
import java.util.ArrayList;
import java.util.List;

public class Cars {

	private List<Car> cars = new ArrayList<>();

	public Cars(List<String> carNames) {
		makeCars(carNames);
	}

	private void makeCars(List<String> carNames) {
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
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
