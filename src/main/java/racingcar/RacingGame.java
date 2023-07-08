package racingcar;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private static final String NEWLINE = "\n";
    private static final String COMMA = ",";
    private static final String DOUBLE_NEWLINE = "\n\n";
    private static final String WINNER_MESSAGE = " 가 최종 우승했습니다.";
    public static final String NON_POSITIVE_EXCEPTION_MESSAGE = "실행 횟수는 양수만 가능합니다";

    private Random random = new Random();

    private final Cars cars;
    private int count;

    public RacingGame(Cars cars, String count) {
        validateCount(count);
        this.cars = cars;
        this.count = Integer.parseInt(count.trim());
    }

    public String play() {
        StringBuilder sb = new StringBuilder();
        while (count-- > 0) {
            cars.move(generateRandom());
            sb.append(getResult());
        }

        sb.append(getResult());
        sb.append(getWinner());

        return sb.toString();
    }

    private int generateRandom() {
        return random.nextInt(10);
    }

    private String getResult() {
        return String.join(NEWLINE, cars.getResult()) + DOUBLE_NEWLINE;
    }

    private String getWinner() {
        return String.join(COMMA, cars.getWinners()) + WINNER_MESSAGE;
    }

    private static void validateCount(String count) {
        if (!count.trim().matches("^[0-9]+$")) {
            throw new RuntimeException(NON_POSITIVE_EXCEPTION_MESSAGE);
        }
    }
}
