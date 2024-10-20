package step5.domain.race;

import java.util.ArrayList;
import java.util.List;

import step5.domain.car.Car;
import step5.domain.car.CarList;

public class RaceHistory {
	private final List<CarPositionMap> raceHistory;

	public RaceHistory() {
		this.raceHistory = new ArrayList<>();
	}

	public List<CarPositionMap> getRaceHistory() {
		return raceHistory;
	}

	public CarPositionMap getRaceHistoryByTime(int moveTime) {
		return raceHistory.get(moveTime);
	}

	public void writeHistory(CarList cars) {
		CarPositionMap timeHistory = new CarPositionMap();
		for (Car car : cars.getList()) {
			timeHistory.writeCarPosition(car.getName(), car.getPosition());
		}
		raceHistory.add(timeHistory);
	}

	public List<String> getWinnerNameList() {
		CarPositionMap endResult = this.getRaceHistoryByTime(this.getMovedTime());
		return endResult.getCurrentWinnerName();
	}

	public int getMovedTime() {
		return this.getRaceHistory().size();
	}
}
