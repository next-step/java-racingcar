package carRacing.car;

import carRacing.car.Car;
import carRacing.numberMaker.NumberMaker;
import java.util.ArrayList;
import java.util.List;

public class CarRacing {

	private List<Car> cars = new ArrayList<>();

	public List<Car> makeCars(int carCount, String[] name) {
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car(name[i]));
		}
		return cars;
	}

	public void moveCars(NumberMaker numberMaker) {
		for (Car car : cars) {
			car.moveCar(numberMaker);
		}
	}
}
