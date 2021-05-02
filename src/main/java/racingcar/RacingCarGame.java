package racingcar;

import java.util.List;
import java.util.Map;

import utils.RandomUtil;

public class RacingCarGame {
	private static final int DEFAULT_RANDOM_MAX = 10;
	private static final int DEFAULT_BASE_NUMBER = 3;
	private static final int GO = 1;
	private ParticipatingCars participatingCars;
	private RoundCount roundCount;
	private AllRoundScore allRoundScore;

	public RacingCarGame(String carNames, int roundCount) {
		this.participatingCars = new ParticipatingCars(carNames);
		this.roundCount = new RoundCount(roundCount);
		this.allRoundScore = new AllRoundScore();
		race();
	}

	public String[] getParticipatingCarNames() {
		List<RacingCar> cars = participatingCars.get();
		int carCount = cars.size();

		String[] carNames = new String[carCount];
		for (int i = 0; i < carCount; i++) {
			carNames[i] = cars.get(i).getName();
		}

		return carNames;
	}

	public List<Map<String, Integer>> getAllRoundScore() {
		return allRoundScore.get();
	}

	private void race() {
		for (int i = 0; i < roundCount.get(); i++) {
			raceOneRound();
			recordCurrentRoundScore();
		}
	}

	private void recordCurrentRoundScore() {
		allRoundScore.recordRoundScore(participatingCars);
	}

	private void raceOneRound() {
		List<RacingCar> cars = participatingCars.get();
		for (int i = 0; i < cars.size(); i++) {
			int pickNumberLessThenTen = RandomUtil.getRandomInt(DEFAULT_RANDOM_MAX);
			if (pickNumberLessThenTen > DEFAULT_BASE_NUMBER) {
				cars.get(i).move(GO);
			}
		}
	}
}
