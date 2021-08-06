package step4;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private static final int INIT_DISTANCE = 0;

	private List<Car> cars;

	private NumberContainer numberContainer;

	public Race(NumberContainer numberContainer, String[] carNames) {
		this.numberContainer = numberContainer;
		cars = new ArrayList<>();
		setCars(carNames);
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

	private void setCars(String[] carNames) {
		for(String name : carNames) {
			cars.add(new Car(name, INIT_DISTANCE));
		}
	}

	private int getMaxDistance() {
		int maxDistance = INIT_DISTANCE;
		for (Car car : cars) {
			maxDistance = car.getMaxDistance(maxDistance);
		}
		return maxDistance;
	}
}
