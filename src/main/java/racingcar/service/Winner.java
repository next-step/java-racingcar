package racingcar.service;

import java.util.*;

import racingcar.domain.Car;

public class Winner {

    private static int maxScore = 0;
    private static List<String> winners = new ArrayList<>();

    public static String getWinners(List<Car> input) {
        getMaxScore(input);

        for (Car car : input) {
            getWinnerName(car);
        }
        return String.join(", ", winners);
    }

    private static int getMaxScore(List<Car> input) {
        for (Car car : input) {
            maxScore = Math.max(maxScore, car.position());
        }
        return maxScore;
    }

    private static void getWinnerName(Car input) {
        if (input.position() == maxScore) {
            winners.add(input.name());
        }
    }
}
