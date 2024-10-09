package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class MovedHistory {
	List<Integer> carPositions;

	public MovedHistory() {
		this.carPositions = new ArrayList<>();
	}

	public static MovedHistory from(List<Car> cars) {
		MovedHistory movedHistory = new MovedHistory();
		movedHistory.writeCarPositions(cars);
		return movedHistory;
	}

	private void writeCarPositions(List<Car> cars) {
		for (Car car : cars) {
			carPositions.add(car.getPosition());
		}
	}

	public List<Integer> getCarPositions() {
		return carPositions;
	}
}
