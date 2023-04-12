package car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

	public List<Car> createCars() {
		return new ArrayList<>();
	}

	public void addCar(List<Car> cars, String carName) {
		cars.add(new Car(carName, 0));
	}
}
