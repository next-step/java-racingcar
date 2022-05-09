package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.view.RoundResult;

public class CountOfGamePlay {
	private int playCount;

	public CountOfGamePlay(int playCount) {
		this.playCount = playCount;
	}

	public void race() {
		if (racing()) {
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
