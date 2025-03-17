package racingcar;

public class Race {
	private int remainingRounds;

	public Race(int rounds) {
		this.remainingRounds = rounds;
	}

	public int getRemainingRounds() {
		return remainingRounds;
	}

	public void reduceRound() {
		remainingRounds--;
	}

	public boolean hasRemainRound() {
		return remainingRounds > 0;
	}

}
