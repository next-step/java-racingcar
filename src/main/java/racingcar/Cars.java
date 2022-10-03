package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> cars = new ArrayList<>();

	public Cars(String[] cars) {
		for (String carName : cars) {
			this.cars.add(new Car(carName));
		}
	}

	public List<Car> getCars() {
		return cars;
	}
}
