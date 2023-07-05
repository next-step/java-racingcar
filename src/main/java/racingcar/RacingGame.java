package racingcar;

import racingcar.car.Cars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGame {

    private final Cars cars;
    private final String NUMBER_PATTERN = "^[0-9]+$";
    private final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private final String JOIN_DELIMITER = " ,";
    private int count;

    public RacingGame(Cars cars, String count) {
        validateCount(count);
        this.cars = cars;
        this.count = Integer.parseInt(count.trim());
    }

    public String play() {
        StringBuilder sb = new StringBuilder();
        while (count-- > 0) {
            cars.move();
            sb.append(getResult());
        }

        sb.append(getResult());
        sb.append(getWinner());

        return sb.toString();
    }

    private String getResult() {
        String result = Arrays.stream(cars.getResult())
                .collect(Collectors.joining("\n"));
        return result + "\n\n";
    }

    private String getWinner() {
        String result = Arrays.stream(cars.getWinners())
                .collect(Collectors.joining(JOIN_DELIMITER));

        return result + WINNER_MESSAGE;
    }

    private void validateCount(String count) {
        if (!count.trim().matches(NUMBER_PATTERN)) {
            throw new RuntimeException("실행 횟수는 양수만 가능합니다");
        }
    }
}
