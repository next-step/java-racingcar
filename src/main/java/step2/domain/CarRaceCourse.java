package step2.domain;

import step2.domain.rules.CarNameRule;
import step2.domain.rules.NumberGenerator;
import step2.domain.rules.RaceRoundRule;
import step2.dto.CarRaceSnapshot;
import step2.dto.CarRaceWinnerNames;

public class CarRaceCourse {

	private RacingCars racingCars;
	private RacingCourse racingCourse;

	public CarRaceCourse(CarNameRule carNameRule, RaceRoundRule raceRoundRule,
						 NumberGenerator randomGenerator) {
		this.racingCars = new RacingCars(carNameRule.getCarNames());
		this.racingCourse = new RacingCourse(randomGenerator, raceRoundRule.getRaceRoundNumber());
	}

	public boolean isNotEndRace() {
		return racingCourse.isNotEndRace();
	}

	public CarRaceSnapshot proceedOneRound() {
		racingCourse.proceedOneRound(racingCars);
		return observeRaceSnapShot();
	}

	private CarRaceSnapshot observeRaceSnapShot() {
		return CarRaceSnapshot.of(racingCars.getCars());
	}

	public CarRaceWinnerNames getResult() {
		racingCourse.validateFinishCarRace();
		return CarRaceWinnerNames.of(racingCars.findWinnerNames());
	}

	public int getCurrentRound() {
		return racingCourse.getCurrentRound();
	}

}
