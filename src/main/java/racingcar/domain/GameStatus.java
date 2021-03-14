package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {
	List<Car> carList = new ArrayList<>();

	public void add(Car car) {
		this.carList.add(car);
	}

	public List<Car> getStatus() {
		return carList;
	}

}
