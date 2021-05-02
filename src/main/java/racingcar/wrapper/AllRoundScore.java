package racingcar.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racingcar.RacingCar;

public class AllRoundScore {
	private List<Map<String, Integer>> roundScore = new ArrayList<>();

	public AllRoundScore() {
	}

	public List<Map<String, Integer>> get() {
		return roundScore;
	}

	public void recordRoundScore(ParticipatingCars cars) {
		Map<String, Integer> scoreOfCars = new HashMap<>();
		for (RacingCar car : cars.get()) {
			scoreOfCars.put(car.getName(), car.getTotalScore());
		}
		roundScore.add(scoreOfCars);
	}
}
