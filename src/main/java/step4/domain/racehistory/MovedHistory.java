package step4.domain.racehistory;

import java.util.ArrayList;
import java.util.List;

import step4.domain.car.Car;
import step4.domain.car.CarList;

public class MovedHistory {
	List<Integer> carPositions;

	public MovedHistory() {
		this.carPositions = new ArrayList<>();
	}

	public static MovedHistory from(CarList cars) {
		MovedHistory movedHistory = new MovedHistory();
		movedHistory.writeCarPositions(cars);
		return movedHistory;
	}

	private void writeCarPositions(CarList cars) {
		for (Car car : cars.getList()) {
			carPositions.add(car.getPosition());
		}
	}

	public List<Integer> getCarPositions() {
		return carPositions;
	}
}
