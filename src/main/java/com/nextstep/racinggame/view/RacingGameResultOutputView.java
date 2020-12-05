package com.nextstep.racinggame.view;

import com.nextstep.racinggame.domain.Car;
import com.nextstep.racinggame.domain.Cars;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameResultOutputView {
    private static final String CAR_STATUS_DIVIDER = " : ";
    private static final String LINE_DIVIDER = "\n";

    static String drawGameProgress(final Cars cars) {
        return cars.getCars().stream()
                .map(RacingGameResultOutputView::drawCarStatus)
                .collect(Collectors.joining());
    }

    private static String drawCarStatus(final Car car) {
        return car.getName() + CAR_STATUS_DIVIDER + drawMoveLine(car.getDistance()) + LINE_DIVIDER;
    }

    private static String drawMoveLine(final int distance) {
        if (distance == 0) {
            return "";
        }

        return IntStream.range(0, distance)
                .mapToObj(number -> "-")
                .collect(Collectors.joining());
    }
}
