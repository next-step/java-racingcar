package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
	private List<Car> cars = new ArrayList<>();

	public void moveCars() {
		for (Car car : cars) {
			car.move(new Random().nextInt(10));
		}
	}

	public void setCars(int carNumber) {
		for (int i = 0; i < carNumber; i++) {
			cars.add(new Car());
		}
	}

	public void viewPositionWithHyphen(int carNumber) {
		for (int i = 0; i < carNumber; i++) {
			System.out.println(cars.get(i).getPositionWithHyphen());
		}
	}
}
