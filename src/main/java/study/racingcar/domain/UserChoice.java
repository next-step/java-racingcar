package study.racingcar.domain;

public class UserChoice {
	private final int carCount;
	private final int gameRounds;

	public UserChoice(int carCount, int gameRounds) {
		this.carCount = carCount;
		this.gameRounds = gameRounds;
	}

	public int userCarCount(){
		return this.carCount;
	}

	public int userGameRounds(){
		return this.gameRounds;
	}
}
