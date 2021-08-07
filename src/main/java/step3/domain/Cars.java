package step3.domain;

import java.util.ArrayList;
import java.util.List;

import step3.utils.RandomUtils;

public class Cars {
	private final List<Car> cars;

	public Cars(String[] names) {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			Car car = new Car(name);
			cars.add(car);
		}
		this.cars = cars;
	}

	public void raceOneTrial() {
		cars.forEach(car -> {
			int randomNumber = RandomUtils.randomNumber();
			car.advanceOrStop(randomNumber);
		});
	}

	public List<Car> getResultOneTrial() {
		return cars;
	}
}
