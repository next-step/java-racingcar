package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private final Cars cars;
    private final int round;

    public Race(Cars cars, int roundCount) {
        this.cars = cars;
        this.round = roundCount;
    }

    public void run() {
        ResultView resultView = new ResultView();

        for (int i = 0; i < round; i++) {
            cars.move();
            resultView.printCurrentRoundProgress(cars);
        }
    }

}
