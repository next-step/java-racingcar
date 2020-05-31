package racingGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Round {
	private List<String> carNames;
	private List<String> score;
	
	public Round(String[] carNames) {
		this.carNames = new ArrayList<String>();
		this.score = new ArrayList<String>();
		for(int i = 0; i < carNames.length; i++) {
			this.carNames.add(carNames[i]);
		}
	}

	public Round registNRoundScore(RacingCar racingCar, int nRound) {
			score.add(racingCar.getRoundPositions(nRound));
		return this;
	}

	public List<String> getCarNames() {
		return carNames;
	}

	public List<String> getScore() {
		return score;
	}
}
