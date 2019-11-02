package racing.view;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RacingScoreView {

    private static final String CAR_TOKEN = "-";
    private static final String RESULT_DELIMITER = "";
    private static final String WINNER_DELIMITER = ", ";
    private static final String RESULT_FORMAT = "{0} : {1}";
    private static final String WINNER_TAIL = "가 최종 우승했습니다.";
    private final int tries;
    private final Map<String, Queue<Integer>> results;

    public RacingScoreView(int tries, Map results) {
        this.tries = tries;
        this.results = results;
    }

    public void printResults() {
        for (int i = 0; i < tries; i++) {
            results.keySet().stream()
                .forEach(carName -> System.out.println(printPosition(carName)));
            System.out.println();
        }
    }

    private String printPosition(String carName) {
        return MessageFormat.format(RESULT_FORMAT, carName,
            String.join(RESULT_DELIMITER,
                Collections.nCopies(results.get(carName).poll(), CAR_TOKEN))
        );
    }

    public void printWinner(List<String> winners) {
        String winnerNames = String.join(WINNER_DELIMITER, winners);
        System.out.println(winnerNames + WINNER_TAIL);
    }
}
