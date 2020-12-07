package racing;

public class RacingGameView {

	public static void main(String[] args) {
		RacingNotifyView racingNotifyView = new RacingNotifyView();
		RacingGame racingGame = new RacingGame(5, 5, racingNotifyView);
		racingGame.start();
	}
}
