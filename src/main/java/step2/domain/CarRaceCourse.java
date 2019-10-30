package step2.domain;

import step2.domain.rules.CarNameRule;
import step2.domain.rules.RaceRoundRule;
import step2.dto.CarRaceSnapshot;
import step2.dto.CarRaceWinnerNames;
import step2.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarRaceCourse {

	private static int CAR_INITIAL_STEP = 0;

	private RacingCars racingCars;
	private RandomGenerator randomGenerator;
	private int currentRound;
	private int maxRound;

	public CarRaceCourse(CarNameRule carNameRule, RaceRoundRule raceRoundRule,
						 RandomGenerator randomGenerator) {
		this.racingCars = new RacingCars(prepareCars(carNameRule.getCarNames()));
		this.randomGenerator = randomGenerator;
		this.currentRound = 0;
		this.maxRound = raceRoundRule.getRaceRoundNumber();
	}

	private List<Car> prepareCars(String[] carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName, CAR_INITIAL_STEP));
		}
		return cars;
	}

	public boolean isNotEndRace() {
		return currentRound != maxRound;
	}

	public CarRaceSnapshot proceedOneRound() {
		validateInProgressCarRace();
		racingCars.moveAllCars(randomGenerator);
		currentRound++;
		return observeRaceSnapShot();
	}

	private void validateInProgressCarRace() {
		if (currentRound >= maxRound) {
			throw new IllegalStateException(String.format("현재 경기 횟수(%s)는 최대 경기 횟수(%s)에 도달했습니다!",
					currentRound, maxRound));
		}
	}

	private CarRaceSnapshot observeRaceSnapShot() {
		return CarRaceSnapshot.of(racingCars.getCars());
	}

	public CarRaceWinnerNames getResult() {
		validateFinishCarRace();
		return CarRaceWinnerNames.of(racingCars.findWinnerNames());
	}

	private void validateFinishCarRace() {
		if (currentRound < maxRound) {
			throw new IllegalStateException(String.format("현재 경기 횟수(%s)는 최대 경기 횟수(%s)에 도달하지 못했습니다!",
					currentRound, maxRound));
		}
	}

	public int getCurrentRound() {
		return currentRound;
	}

}
