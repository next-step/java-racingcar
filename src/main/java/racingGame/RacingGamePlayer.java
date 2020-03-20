package racingGame;

public class RacingGamePlayer {
	private InputView inputView;
	private ResultView resultView;

	public RacingGamePlayer() {
		inputView = new InputView();
		resultView = new ResultView();
	}

	public void racingStart(){
		inputView.startInput();
		RacingGame racingGame = new RacingGame(inputView.getCarCount());
		resultView.printResultStart();
		for (int i = 0; i < inputView.getRacingTime(); i++) {
			resultView.printResult(racingGame.move());
			System.out.println();
		}
	}

	public static void main(String[] args){
		new RacingGamePlayer().racingStart();
	}
}
