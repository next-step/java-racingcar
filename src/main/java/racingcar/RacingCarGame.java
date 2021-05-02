package racingcar;

import java.util.List;
import java.util.Map;

import utils.RandomUtil;

public class RacingCarGame {
	private static final int DEFAULT_RANDOM_MAX = 10;
	private ParticipatingCars participatingCars;
	private RoundCount roundCount;
	private AllRoundScore allRoundScore;
	private Winners winners;

	public RacingCarGame(String carNames, int roundCount) {
		this.participatingCars = new ParticipatingCars(carNames);
		this.roundCount = new RoundCount(roundCount);
		this.allRoundScore = new AllRoundScore();
		this.winners = new Winners();
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

	public List<String> getWinners() {
		return winners.get();
	}

	private void race() {
		for (int i = 0; i < roundCount.get(); i++) {
			raceOneRound();
			recordCurrentRoundScore();
		}
		whoIsTheWinners();
	}

	private void whoIsTheWinners() {
		int max = getMaxScore();
		for (RacingCar car : participatingCars.get()) {
			winners.select(car, max);
		}
	}

	private int getMaxScore() {
		int max = 0;
		for (RacingCar car : participatingCars.get()) {
			max = max < car.getTotalScore() ? car.getTotalScore() : max;
		}
		return max;
	}

	private void recordCurrentRoundScore() {
		allRoundScore.recordRoundScore(participatingCars);
	}

	private void raceOneRound() {
		List<RacingCar> cars = participatingCars.get();
		for (int i = 0; i < cars.size(); i++) {
			int pickNumberLessThenTen = RandomUtil.getRandomInt(DEFAULT_RANDOM_MAX);
			cars.get(i).move(pickNumberLessThenTen);
		}
	}
}
