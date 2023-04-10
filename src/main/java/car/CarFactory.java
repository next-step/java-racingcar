package car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

	public List<Car> createCars() {
		return new ArrayList<>();
	}

	public void addCar(List<Car> cars) {
		cars.add(new Car());
	}

	public void moveCars(List<Car> cars) {
		for (Car car : cars) {
			car.move(car.randomInt());
		}
	}
}
