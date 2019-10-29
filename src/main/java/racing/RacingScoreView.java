package racing;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

class RacingScoreView {

    private static final String CAR_TOKEN = "-";
    private static final String RESULT_DELIMITER = "";
    private static final String WINNER_DELIMITER = ", ";
    private static final String RESULT_FORMAT = "{0} : {1}";
    private static final String WINNER_TAIL = "가 최종 우승했습니다.";
    private final RacingGame racingGame;
    private final List<Car> cars;

    RacingScoreView(RacingGame racingGame) {
        this.racingGame = racingGame;
        this.cars = racingGame.getCars();
    }

    void printResults() {
        for (int i = 0; i < racingGame.getTries(); i++) {
            cars.stream().forEach(car -> System.out.println(printPosition(car)));
            System.out.println();
        }
    }

    private String printPosition(Car car) {
        return MessageFormat.format(RESULT_FORMAT, car.getName(),
            String.join(RESULT_DELIMITER,
                Collections.nCopies(car.getRecords().poll(), CAR_TOKEN))
        );
    }

    void printWinner() {
        String winnerNames = String.join(WINNER_DELIMITER, racingGame.getWinnerNames());
        System.out.println(winnerNames + WINNER_TAIL);
    }
}
