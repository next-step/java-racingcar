package racing.controller;

import racing.domain.Racing;
import racing.domain.RandomMoveStrategy;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;
import java.util.Random;

public class RacingMain {
    static Random random = new Random();

    public static void main(String[] args) {
        // view
        String carNames = InputView.getCarName();
        int tryCount = InputView.getTryCount();
        Racing racing = new Racing(carNames, tryCount);

        for(int i=0; i<tryCount; i++) {
            racing.racingStart(new RandomMoveStrategy());
            ResultView.viewResultView(racing.getCars());
        }

        ResultView.winnerView(racing.findWinner());
    }

}
