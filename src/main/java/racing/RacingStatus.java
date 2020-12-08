package racing;

import racing.car.Car;

import java.util.List;

public class RacingStatus {
	private final List<Car> carList;

	public RacingStatus(List<Car> carList) {
		this.carList = carList;
	}

	public List<Car> getCarList() {
		return carList;
	}
}
