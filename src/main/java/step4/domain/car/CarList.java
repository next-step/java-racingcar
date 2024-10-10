package step4.domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarList {
	List<Car> cars;

	public CarList(List<Car> cars) {
		this.cars = cars;
	}

	public static CarList from(String[] nameList) {
		List<Car> cars = new ArrayList<>();
		for (String name : nameList) {
			cars.add(new Car(name));
		}
		return new CarList(cars);
	}

	public void moveCarList() {
		for (Car car : cars) {
			car.move(car.getMoveStrategy().movable());
		}
	}

	public List<Car> getList() {
		return cars;
	}

	public int getSize() {
		return cars.size();
	}
}
