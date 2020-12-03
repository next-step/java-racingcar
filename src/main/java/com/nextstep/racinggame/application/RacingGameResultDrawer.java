package com.nextstep.racinggame.application;

import com.nextstep.racinggame.domain.Cars;
import com.nextstep.racinggame.domain.CurrentDistance;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameResultDrawer {
    public static String drawGameResult(final Cars cars) {
        CurrentDistance currentDistance = cars.calculateCurrentDistance();

        return currentDistance.getValues().stream()
                .map(distance -> drawMoveLine(distance) + "\n")
                .collect(Collectors.joining());
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
