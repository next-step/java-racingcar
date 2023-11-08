package racingcar.service;

import java.util.*;

import racingcar.domain.Car;

public class Winner {

    private static int MAX_SCORE = 0;
    private static List<String> winners = new ArrayList<>();

    public static String getWinners(List<Car> input) {
        maxScore(input);

        for (Car car : input) {
            getWinnerName(car);
        }
        return String.join(", ", winners);
    }

    private static int maxScore(List<Car> input) {
        for (Car car : input) {
            MAX_SCORE = Math.max(MAX_SCORE, car.position());
        }
        return MAX_SCORE;
    }

    private static void getWinnerName(Car input) {
        if (input.position() == MAX_SCORE) {
            winners.add(input.name());
        }
    }
}
