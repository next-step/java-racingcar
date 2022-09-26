package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	public List<Car> cars;

	public Cars participate(int participant) {
		cars = new ArrayList<>();
		for (int i = 0; i < participant; i++) {
			cars.add(new Car());
		}
		return this;
	}
}
