package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars of(int numberOfCars) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(new Car());
		}
		return new Cars(cars);
	}


}
