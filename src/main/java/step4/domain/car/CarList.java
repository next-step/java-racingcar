package step4.domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarList {
	List<Car> cars;
	int movedCount;

	public CarList(List<Car> cars) {
		this.cars = cars;
		this.movedCount = 0;
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
		this.movedCount++;
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
			if (maxValue < car.getCurrentPosition()) {
				maxValue = car.getCurrentPosition();
			}
		}
		for (Car car : cars) {
			if (car.getCurrentPosition() == maxValue) {
				winnerList.add(car);
			}
		}
		return winnerList;
	}

	public int getMovedCount() {
		return movedCount;
	}
}
