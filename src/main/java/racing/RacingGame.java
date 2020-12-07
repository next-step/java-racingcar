package racing;

public class RacingGame {
	private final int turn;
	private final RacingNotifier racingNotifier;

	public RacingGame(int turn, RacingNotifier racingNotifier) {
		this.turn = turn;
		this.racingNotifier = racingNotifier;
	}

	public RacingStatus start() {
		for (int i = 0; i < turn; i++) {
			racingNotifier.notify(new RacingStatus());
		}

		return new RacingStatus();
	}
}
