package racing.controller;

import racing.domain.Racing;
import racing.domain.RandomMoveStrategy;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.Random;

public class RacingMain {
    static Random random = new Random();

    public static void main(String[] args) {
        // view
        InputView.setCarCount();
        InputView.setTryCount();
        Racing racing = new Racing();

        for(int i=0; i<InputView.getTryCount(); i++) {
            racing.racingStart(new RandomMoveStrategy());
            ResultView.viewResultView(racing.getCars());
        }
    }

}
