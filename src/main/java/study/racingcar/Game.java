package study.racingcar;

public class Game {

	private int gameCount;

	public Game() {
		this.gameCount = 0;
	}

	public void createGameCount(int userInputCount) {
		this.gameCount = userInputCount;
	}

	public int countGame() {
		return this.gameCount;
	}
}
