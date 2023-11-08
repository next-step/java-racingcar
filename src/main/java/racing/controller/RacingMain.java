package racing.controller;

import racing.domain.Racing;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.Random;

public class RacingMain {

    public static void main(String[] args) {
        // view
        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();

        Racing racing = new Racing(carCount, tryCount);

        for(int i=0; i<tryCount; i++) {
            racingStart(carCount, racing);
            ResultView.viewResultView(racing.getCars());
        }
    }

    private static void racingStart(int carCount, Racing racing) {
        for (int j = 0; j < carCount; j++) {
            racing.racingStart(j, new Random().nextInt(10));
        }
    }

}
