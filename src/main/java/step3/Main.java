package step3;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int carCnt = InputView.generateCarCnt();
        int tryCnt = InputView.generateTryCnt();

        RacingGame racingGame = new RacingGame(carCnt, tryCnt);
        RacingGameHandler racingGameHandler = new RacingGameHandler(racingGame, new RandomMoveStrategy());
        List<List<Integer>> racingResults = racingGameHandler.playWithMoveStrategy();

        new ResultView().showResult(racingResults);
    }
}
