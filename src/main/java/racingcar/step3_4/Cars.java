package racingcar.step3_4;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars createCars(Names carNames) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < carNames.getCount(); i++) {
			cars.add(new Car());
		}

		return new Cars(cars);
	}

	public void move(RandomValueGenerator randomValueGenerator) {
		for (Car car : cars) {
			car.move(randomValueGenerator);
		}
	}

	public int getCarsCount() {
		return cars.size();
	}

	public List<Car> getCars() {
		return List.copyOf(this.cars);
	}
}
