package step2.domain;

import step2.domain.rules.CarNumberRule;
import step2.domain.rules.RaceRoundRule;
import step2.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarRaceCourse {

	private List<Car> cars = new ArrayList<>();
	private RandomGenerator randomGenerator;
	private int currentRound;
	private int maxRound;

	public CarRaceCourse(CarNumberRule carNumberRule, RaceRoundRule raceRoundRule, RandomGenerator randomGenerator) {
		prepareCars(carNumberRule.getCarNumber());
		this.randomGenerator = randomGenerator;
		this.currentRound = 0;
		this.maxRound = raceRoundRule.getRaceRoundNumber();
	}

	private void prepareCars(int numberOfCarsParticipated) {
		for (int i = 0; i < numberOfCarsParticipated; i++) {
			cars.add(new Car());
		}
	}

	public boolean isNotEndRace() {
		return currentRound != maxRound;
	}

	public CarRaceSnapshot proceedOneRound() {
		for (Car car : cars) {
			car.moveIfLucky(randomGenerator.getRandomNumber());
		}
		currentRound++;
		return observeRaceSnapShot();
	}

	private CarRaceSnapshot observeRaceSnapShot() {
		return new CarRaceSnapshot(cars);
	}

	public int getCurrentRound() {
		return currentRound;
	}

}
