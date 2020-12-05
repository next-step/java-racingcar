package com.nextstep.racinggame.view;

import com.nextstep.racinggame.domain.Car;
import com.nextstep.racinggame.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameWinnerOutputView {
    private static final String WINNER_FOOTER = "가 최종 우승했습니다.";
    private static final String WINNER_DIVIDER = ", ";
    private static final int USELESS_FOOTER_SIZE = 2;

    static String parseToWinnerResult(Cars cars) {
        return parseToWinners(cars.getCars()) + WINNER_FOOTER;
    }

    private static String parseToWinners(List<Car> cars) {
        String rawWinners = cars.stream()
                .map(car -> car.getName() + WINNER_DIVIDER)
                .collect(Collectors.joining());

        return rawWinners.substring(0, rawWinners.length() - USELESS_FOOTER_SIZE);
    }
}
