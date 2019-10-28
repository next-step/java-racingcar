package racing;

import java.util.Collections;
import java.util.List;

class RacingScoreView {

    private static final String CAR_TOKEN = "-";
    private static final String DELIMITER = "";
    private final RacingGame racingGame;

    RacingScoreView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    void printResult() {
        List<Car> cars = racingGame.getCars();
        for (Car car : cars) {
            int final_record = car.getPosition();
            System.out
                .println(String.join(DELIMITER, Collections.nCopies(final_record, CAR_TOKEN)));
        }
    }
}
