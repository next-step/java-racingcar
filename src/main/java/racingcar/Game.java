package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
	List<Car> carList = new ArrayList<>();

	public void makeCar(int carListSize) {
		for (int i = 0; i < carListSize; i++) {
			carList.add(new Car());
		}
	}

	public List<Car> getCar() {
		return carList;
	}
}
