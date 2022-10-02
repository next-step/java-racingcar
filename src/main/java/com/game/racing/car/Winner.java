package com.game.racing.car;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private static Integer WINNER_POSITION = 0;

    public static Integer getWinnerPosition() {
        return WINNER_POSITION;
    }

    public static void compareWithWinnerPosition(int position) {
        if (position > WINNER_POSITION) {
            WINNER_POSITION = position;
        }
    }

    public static void resetWinnerPositionValue() {
        WINNER_POSITION = 0;
    }

    public static List<Car> getRacingWinners(Cars cars) {
        return cars.getRacingCars().stream()
                .filter(car -> car.getPosition().get() == WINNER_POSITION)
                .collect(Collectors.toList());
    }
}
