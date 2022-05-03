package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.view.RoundResult;

public class CountOfGamePlay {
	private int playCount;

	public CountOfGamePlay(int playCount) {
		this.playCount = playCount;
	}

	public List<RoundResult> run(RacingCars racingCars, EngineStrategy engineStrategy) {
		List<RoundResult> results = new ArrayList<>();
		for (int i = 0; i < playCount; i++) {
			race(racingCars, engineStrategy);
		}
		return results;
	}

	public void race(RacingCars racingCars, EngineStrategy engineStrategy) {
		if (racing()) {
			racingCars.play(engineStrategy);
			playCount--;
		}
	}

	public boolean racing() {
		return playCount > 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CountOfGamePlay that = (CountOfGamePlay)o;

		return playCount == that.playCount;
	}

	@Override
	public int hashCode() {
		return playCount;
	}
}
