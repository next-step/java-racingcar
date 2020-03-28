package domain;

import java.util.List;

public class RacingGame {

    public void playGame(Cars cars, List<Integer> randomNumbers) {
        cars.move(randomNumbers);
    }

}
