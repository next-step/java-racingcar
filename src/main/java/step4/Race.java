package step4;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private static final int INIT_INSTANCE = 0;

	private List<Car> cars;

	private NumberContainer numberContainer;

	public Race(NumberContainer numberContainer) {
		this.numberContainer = numberContainer;
		cars = new ArrayList<>();
	}

	public List<Car> getCars() {
		return cars;
	}

	public void startRace() {
		for (Car car : cars) {
			int randomNumber = numberContainer.getRandomNumber();
			car.move(randomNumber);
		}
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public List<Car> getWinners() {
		List<Car> winners = new ArrayList<>();
		int maxDistance = getMaxDistance();
		for (Car car : cars) {
			if (car.getStatusWinnerStatus(maxDistance)) {
				winners.add(car);
			}
		}
		return winners;
	}

	private int getMaxDistance() {
		int maxDistance = INIT_INSTANCE;
		for (Car car : cars) {
			maxDistance = car.getMaxDistance(maxDistance);
		}
		return maxDistance;
	}
}
