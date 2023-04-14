package step3_racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(int carCount) {
		cars = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
	}

	public List<Car> getCars() {
		return cars;
	}
}
