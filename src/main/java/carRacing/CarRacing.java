package carRacing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

	private List<Car> cars = new ArrayList<>();

	public List<Car> makeCars(int carCount) {
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
		return cars;
	}

	public void moveCars(List<Car> cars, RandomNumMaker randomNumMaker) {
		for (Car car : cars) {
			car.moveCar(randomNumMaker.makeRandomNumber());
		}
	}
}
