package step4;

import step4.strategy.ProdMove;

public class GameStarter {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(inputView.getCarNames(), new ProdMove());

        int playCnt = inputView.getPlayCount();
        ResultView resultView = new ResultView();
        for (int i = 0; i < playCnt; i++) {
            Cars cars = racingGame.play();
            resultView.showResult(cars, isLastGame(playCnt, i));
        }
    }

    private static boolean isLastGame(int playCnt, int curPlayCnt) {
        return curPlayCnt == playCnt - 1 ? true : false;
    }
}
