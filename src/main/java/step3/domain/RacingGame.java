package step3.domain;

public class RacingGame {

	private static final int BOUNDARY_NUMBER = 4;
	private static final int MAX_NUMBER = 10;

	public Participants doTurn(Participants participants) {
		participants.move(BOUNDARY_NUMBER, MAX_NUMBER);

		return participants;
	}

}
