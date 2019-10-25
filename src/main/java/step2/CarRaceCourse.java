package step2;

import java.util.ArrayList;
import java.util.List;

public class CarRaceCourse {

	private List<Car> cars = new ArrayList<>();
	private int round;
	private int maxRound;

	public CarRaceCourse(int numberOfCarsParticipated, int maxRound) {
		prepareCars(numberOfCarsParticipated);
		this.round = 0;
		this.maxRound = maxRound;
	}

	private void prepareCars(int numberOfCarsParticipated) {
		for (int i = 0; i < numberOfCarsParticipated; i++) {
			cars.add(new Car());
		}
	}

	public boolean isNotEndRace() {
		return round != maxRound;
	}

	public void proceedOneRound() {
		for (Car car : cars) {
			car.moveIfLucky();
		}
		this.round ++;
	}

	/**
	 * 각각의 자동차가 몇 칸(step)을 전진해 있는지 반환한다
	 */
	public List<Integer> observeRaceSnapShot() {
		List<Integer> result = new ArrayList<>();
		for (Car car : cars) {
			result.add(car.getStep());
		}
		return result;
	}

	public int getRound() {
		return this.round;
	}

}
