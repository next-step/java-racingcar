package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {
	List<Car> carList = new ArrayList<>();

	public GameStatus(Car... cars) {
		for (int i = 0; i < cars.length; i++) {
			add(cars[i]);
		}
	}

	public void add(Car car) {
		this.carList.add(car);
	}

	public List<Car> getStatus() {
		return carList;
	}

}
