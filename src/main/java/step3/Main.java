package step3;

public class Main {

    public static void main(String[] args) {

        int carCnt = InputView.generateCarCnt();
        int tryCnt = InputView.generateTryCnt();

        RacingGame racingGame = new RacingGame(carCnt, tryCnt);

        ResultView resultView = new ResultView(racingGame);

        resultView.playWithMoveStrategy(new RandomMoveStrategy());
    }
}
