package racingcar;

public class Score {
	private static final int DEFAULT_SCORE = 0;
	private int score;

	public Score() {
		this.score = DEFAULT_SCORE;
	}

	public int getScore() {
		return score;
	}

	public int add(int score) {
		return this.score += score;
	}
}
