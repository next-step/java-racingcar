package step4.domain.race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step4.domain.car.Car;
import step4.domain.car.CarList;

public class CarHistory {
	private final List<Map<String, Integer>> raceHistory;

	public CarHistory() {
		this.raceHistory = new ArrayList<>();
	}

	public List<Map<String, Integer>> getRaceHistory() {
		return raceHistory;
	}

	public void writeHistory(CarList cars) {
		Map<String, Integer> timeHistory = new HashMap<>();
		for (Car car : cars.getList()) {
			timeHistory.put(car.getName(), car.getPosition());
		}
		raceHistory.add(timeHistory);
	}
}
