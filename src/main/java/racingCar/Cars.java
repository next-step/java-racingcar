package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	public void move() {
		for (int i = 0; i < this.cars.size(); i++) {
			int rand = new Random().nextInt(10);
			this.cars.get(i).movingOfRound(rand);
		}
	}
}
