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

	public List<Car> getWinner() {
		List<Car> winnerList = new ArrayList<>();
		int maxValue = 0;
		for (Car car : cars) {
			if (maxValue < car.getPosition()) {
				maxValue = car.getPosition();
			}
		}
		for (Car car : cars) {
			if (car.getPosition() == maxValue) {
				winnerList.add(car);
			}
		}
		return winnerList;
	}
}
