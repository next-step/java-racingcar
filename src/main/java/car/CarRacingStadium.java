package car;

import java.util.ArrayList;
import java.util.List;

public class CarRacingStadium {

	public void moveCars(List<Car> cars) {
		for (Car car : cars) {
			car.move(car.randomInt());
		}
	}

	public int getBestLocation(List<Car> cars) {
		int bestLocation = 0;
		for (Car car : cars) {
			bestLocation = updateBetterLocation(bestLocation, car);
		}
		return bestLocation;
	}

	private int updateBetterLocation(int bestLocation, Car car) {
		if (car.currentLocation() > bestLocation) {
			bestLocation = car.currentLocation();
		}
		return bestLocation;
	}

	public List<String> createWinners(List<Car> cars, int bestLocation) {
		List<String> winners = new ArrayList<>();
		for (Car car : cars) {
			addWinner(car, bestLocation, winners);
		}
		return winners;
	}

	private void addWinner(Car car, int bestLocation, List<String> winners) {
		if (car.currentLocation() == bestLocation) {
			winners.add(car.getName());
		}
	}
}
