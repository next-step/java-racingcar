package step4;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private static final int INIT_DISTANCE = 0;

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

	public void addCar(final String carName) {
		cars.add(new Car(carName));
	}

	public List<Car> getWinners() {
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {

		}
		return winners;
	}

	public int getLongestDistance() {
		int longestDistance = INIT_DISTANCE;
		for (Car car : cars) {
			longestDistance = compareDistance(car, longestDistance);
		}
		return longestDistance;
	}

	private int compareDistance(Car car, int currentLongestDistance) {
		return car.getDistance() > currentLongestDistance ? car.getDistance() : currentLongestDistance;
	}
}
