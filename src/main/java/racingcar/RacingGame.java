package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private static final String NEWLINE = "\n";
    private static final String COMMA = ",";
    private static final String DOUBLE_NEWLINE = "\n\n";
    private static final String WINNER_MESSAGE = " 가 최종 우승했습니다.";

    private final Cars cars;
    private Count count;

    public RacingGame(Cars cars, Count count) {
        this.cars = cars;
        this.count = count;
    }

    public List<String> play() {
        List<String> playResult = new ArrayList<>();

        while (count.isRemaining()) {
            cars.move();
            count = count.tryOnce();

            playResult.add(getResult());
        }

        playResult.add(getResult());
        playResult.add(getWinner());

        return playResult;
    }

    private String getResult() {
        return String.join(NEWLINE, cars.getResult()) + DOUBLE_NEWLINE;
    }

    private String getWinner() {
        return String.join(COMMA, cars.getWinners()) + WINNER_MESSAGE;
    }


}
