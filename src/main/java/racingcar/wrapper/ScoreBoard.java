package racingcar.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racingcar.RacingCar;

public class ScoreBoard {
	private List<Map<String, Integer>> allCarsScoreByEachRound = new ArrayList<>();

	public ScoreBoard() {
	}

	public List<Map<String, Integer>> get() {
		return allCarsScoreByEachRound;
	}

	public void recordRoundScore(ParticipatingCars cars) {
		Map<String, Integer> scoreOfCars = new HashMap<>();
		for (RacingCar car : cars.get()) {
			scoreOfCars.put(car.getName(), car.getTotalScore());
		}
		allCarsScoreByEachRound.add(scoreOfCars);
	}
}
