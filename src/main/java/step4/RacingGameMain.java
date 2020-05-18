package step4;


public class RacingGameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame();

        racingGame.initialize(inputView.enterCarNames(), inputView.enterTryCount());

        resultView.printResultTitle();
        for (int i = 0; i < racingGame.getTryCount(); ++i) {
            racingGame.goCars();
            resultView.printCurrentResult(racingGame);
        }

        racingGame.chooseWinners();
        resultView.printWinners(racingGame);
    }
}
