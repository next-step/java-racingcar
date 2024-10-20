package step5.domain.car;

import java.util.List;

public class CarList {
	List<Car> cars;

	public CarList(List<Car> cars) {
		this.cars = cars;
	}

	public void moveAll() {
		for (Car car : cars) {
			car.move();
		}
	}

	public List<Car> getList() {
		return cars;
	}
}
