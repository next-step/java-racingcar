package repository;

import java.util.List;

import domain.Car;

public class CarHistory {

	public List<Car> savedCarHistory;

	public void saveCarHistory(List<Car> carList) {
		savedCarHistory = carList;
	}

	public List<Car> getSavedCarHistory() {
		return savedCarHistory;
	}
}
