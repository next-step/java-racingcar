package carRacing.car;

import java.util.ArrayList;
import java.util.List;

public class CarWinner {

	private static final int DEFAULT_POSITION = 0;

	List<Car> winnerList = new ArrayList<>();

	public List<Car> makeWinnerList(List<Car> carList) {
		int maxPosition = findMaxPosition(carList);
		sameWithMaxPosition(carList, maxPosition);
		return winnerList;
	}

	private int findMaxPosition(List<Car> carList) {
		int maxPosition = DEFAULT_POSITION;
		for (Car car : carList) {
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
		return maxPosition;
	}

	private void sameWithMaxPosition(List<Car> carList, int maxPosition) {
		for (Car car : carList) {
			addWinnerCar(maxPosition, car);
		}
	}

	private void addWinnerCar(int maxPosition, Car car) {
		if (car.getPosition() == maxPosition) {
			winnerList.add(car);
		}
	}
}
