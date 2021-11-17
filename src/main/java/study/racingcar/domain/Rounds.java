package study.racingcar.domain;

public class Rounds {

	private final int round;

	public Rounds(int userInputRound) {
		this.round = userInputRound;
	}

	public int numOfRounds() {
		return this.round;
	}

}
