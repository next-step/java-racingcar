package racing.view;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import racing.domain.Car;
import racing.domain.RacingGame;

public class RacingScoreView {

    private static final String CAR_TOKEN = "-";
    private static final String RESULT_DELIMITER = "";
    private static final String WINNER_DELIMITER = ", ";
    private static final String RESULT_FORMAT = "{0} : {1}";
    private static final String WINNER_TAIL = "가 최종 우승했습니다.";
    private final RacingGame racingGame;
    private final List<Car> cars;
    private final Map<String, Queue<Integer>> results;

    public RacingScoreView(RacingGame racingGame) {
        this.racingGame = racingGame;
        this.cars = racingGame.getCars();
        this.results = racingGame.getResults();
    }

    public void printResults() {
        int tries = racingGame.getTries();
        for (int i = 0; i < tries; i++) {
            cars.stream().forEach(car -> System.out.println(printPosition(car)));
            System.out.println();
        }
    }

    private String printPosition(Car car) {
        return MessageFormat.format(RESULT_FORMAT, car.getName(),
            String.join(RESULT_DELIMITER,
                Collections.nCopies(results.get(car.getName()).poll(), CAR_TOKEN))
        );
    }

    public void printWinner() {
        String winnerNames = String.join(WINNER_DELIMITER, racingGame.getWinnerNames());
        System.out.println(winnerNames + WINNER_TAIL);
    }
}
