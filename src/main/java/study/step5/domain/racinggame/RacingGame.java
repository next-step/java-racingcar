package study.step5.domain.racinggame;

public class RacingGame {
	private final RacingGameInfo racingGameInfo;

	public RacingGame(RacingGameInfo racingGameInfo) {
		this.racingGameInfo = racingGameInfo;
	}

	public void start() {
		while (racingGameInfo.getCurrentRound() < racingGameInfo.getRound()) {
			this.play();
		}
	}

	private void play() {
		racingGameInfo.getParticipants().moveAll(racingGameInfo.getMoveStrategy());
		racingGameInfo.setMaxPosition();
		racingGameInfo.addCurrentRound();
		racingGameInfo.printParticipants();
	}

	public void end() {
		racingGameInfo.findWinners();
		racingGameInfo.printWinners();
	}
}
