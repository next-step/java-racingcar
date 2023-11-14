package racingCar.car;

import java.util.List;

public class Cars {
	private final List<Car> carList;

	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	public List<Car> carList() {
		return carList;
	}

	public void moveOnce() {
		for (Car car : carList) {
			car.move();
		}
	}
}
