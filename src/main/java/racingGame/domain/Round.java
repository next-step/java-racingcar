package racingGame.domain;

import java.util.List;

public class Round {
	private String[] carNames;
	private String[] score;
	
	public Round(String[] carNames) {
		this.carNames = carNames;
		this.score = new String[carNames.length];
	}

	public Round registNRoundScore(List<RacingCar> racingCars, int nRound) {
		for(int i = 0; i < racingCars.size(); i++) {
			score[i] = racingCars.get(i).getRoundPositions(nRound);
		}
		return this;
	}

	public String[] getCarNames() {
		return carNames;
	}

	public String[] getScore() {
		return score;
	}
}
