package carRacing;

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

	public void moveCars(List<Car> cars, RandomNumMaker randomNumMaker) {
		for (Car car : cars) {
			car.moveCar(randomNumMaker.makeRandomNumber());
		}
	}
}
