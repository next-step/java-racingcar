package racing.controller;

import racing.domain.Racing;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.Random;

public class RacingMain {
    static Random random = new Random();

    public static void main(String[] args) {
        // view
        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();

        Racing racing = new Racing(carCount, tryCount);

        for(int i=0; i<tryCount; i++) {
            racing.racingStart(random);
            ResultView.viewResultView(racing.getCars());
        }
    }

}
