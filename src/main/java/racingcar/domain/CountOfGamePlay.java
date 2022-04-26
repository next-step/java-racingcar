package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.view.RoundResult;

public class CountOfGamePlay {
	private final int playCount;

	public CountOfGamePlay(int playCount) {
		this.playCount = playCount;
	}

	public List<RoundResult> run(RacingCars racingCars, EngineStrategy engineStrategy) {
		List<RoundResult> results = new ArrayList<>();
		for (int i = 0; i < playCount; i++) {
			results.add(racingCars.play(engineStrategy));
		}
		return results;
	}
}
