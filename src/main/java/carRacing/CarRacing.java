package carRacing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

	private List<Car> cars = new ArrayList<>();

	public List<Car> makeCars(int input) {
		for (int i = 0; i < input; i++) {
			cars.add(new Car());
		}
		return cars;
	}
}
