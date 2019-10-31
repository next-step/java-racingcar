package step2.domain;

import step2.domain.rules.NumberGenerator;

class RacingCourse {

	private NumberGenerator numberGenerator;
	private RacingInfo racingInfo;

	RacingCourse(NumberGenerator numberGenerator, int maxRound) {
		this.numberGenerator = numberGenerator;
		this.racingInfo = new RacingInfo(maxRound);
	}

	void proceedOneRound(RacingCars racingCars) {
		racingInfo.validateInProgressCarRace();
		racingCars.moveAllCars(numberGenerator);
		racingInfo.updateOneRound();
	}

	boolean isNotEndRace() {
		return racingInfo.isNotEndRace();
	}

	void validateFinishCarRace() {
		racingInfo.validateFinishCarRace();
	}

	int getCurrentRound() {
		return racingInfo.getCurrentRound();
	}

}
