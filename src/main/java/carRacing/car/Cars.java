package carRacing.car;

import carRacing.moveStrategy.MoveStrategy;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;

public class Cars {

	private List<Car> cars = new ArrayList<>();

	public Cars() {
	}

	public Cars(int carCount, String[] name) {
		makeCars(carCount, name);
	}

	public List<Car> makeCars(int carCount, String[] name) {
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car(name[i]));
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
