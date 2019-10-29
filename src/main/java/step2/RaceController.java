package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceController {

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int tryCount = InputView.getTryCount();

        List<Integer> carPositions = new ArrayList<>(Collections.nCopies(numberOfCars, 0));

        RacingGame racingGame = new RacingGame(carPositions);

        ResultView.printStartMessage();

        for (int i = 0; i < tryCount; i++) {
            carPositions = racingGame.move();
            ResultView.print(carPositions);
        }
    }
}
