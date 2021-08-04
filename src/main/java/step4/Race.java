package step4;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private final int INIT_DISTANCE = 0;

	private int longestDistance;
	private List<Car> winners;
	private List<Car> cars;

	private NumberContainer numberContainer;

	public Race(NumberContainer numberContainer) {
		this.numberContainer = numberContainer;
		this.longestDistance = INIT_DISTANCE;
		winners = new ArrayList<>();
		cars = new ArrayList<>();
	}

	public List<Car> getCars() {
		return cars;
	}

	public void startRace() {
		for(Car car : cars) {
			int randomNumber = numberContainer.getRandomNumber();
			car.move(randomNumber);
		}
	}

	public void addCar(String carName) {
		cars.add(new Car(carName));
	}

	public List<Car> getWinners() {
		for(Car car : cars) {
			setWinners(car);
		}
		return winners;
	}

	public void updateLongestDistance() {
		for(Car car : cars) {
			checkCarDistance(car);
		}
	}

	private void setWinners(Car car) {
		if(car.getDistance() == longestDistance) {
			winners.add(car);
		}
	}

	private void checkCarDistance(Car car) {
		if(car.getDistance() > longestDistance) {
			longestDistance = car.getDistance();
		}
	}
}
