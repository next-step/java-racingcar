package step4;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private NumberContainer numberContainer;
	private int longestDistance;
	private final int INIT_DISTANCE = 0;
	private List<Car> winners;

	public Race(NumberContainer numberContainer) {
		this.numberContainer = numberContainer;
		this.longestDistance = INIT_DISTANCE;
		winners = new ArrayList<>();
	}

	public void startRace(List<Car> cars) {
		for(Car car : cars) {
			int randomNumber = numberContainer.getRandomNumber();
			car.move(randomNumber);
		}
	}

	public List<Car> getWinners(List<Car> cars) {
		for(Car car : cars) {
			setWinners(car);
		}
		return winners;
	}

	public void updateLongestDistance(List<Car> cars) {
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
