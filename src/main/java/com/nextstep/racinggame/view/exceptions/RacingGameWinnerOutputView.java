package com.nextstep.racinggame.view.exceptions;

import com.nextstep.racinggame.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameWinnerOutputView {
    private static final String WINNER_FOOTER = "가 최종 우승했습니다.";
    private static final String WINNER_DIVIDER = ", ";

    public static String parseToWinnerResult(List<Car> cars) {
        return parseToWinners(cars) + WINNER_FOOTER;
    }

    private static String parseToWinners(List<Car> cars) {
        String rawWinners = cars.stream()
                .map(car -> car.getName() + WINNER_DIVIDER)
                .collect(Collectors.joining());
        return rawWinners.substring(0, rawWinners.length() - 2);
    }
}
