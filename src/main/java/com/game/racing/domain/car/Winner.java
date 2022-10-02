package com.game.racing.domain.car;

import com.game.racing.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private static Integer WINNER_POSITION = 0;

    public static Integer getWinnerPosition() {
        return WINNER_POSITION;
    }

    private final List<Car> winners;

    public Winner(Cars racingCars) {
        this.winners = racingCars.getRacingCars().stream()
                .filter(car -> car.getPosition().get() == WINNER_POSITION)
                .collect(Collectors.toUnmodifiableList());
    }

    public static void compareWithWinnerPosition(int position) {
        if (position > WINNER_POSITION) {
            WINNER_POSITION = position;
        }
    }

    public static void resetWinnerPositionValue() {
        WINNER_POSITION = 0;
    }

    public Integer printWinnersAndGetWinnersSize() {
        ResultView.printWinner(winners);
        return winners.size();
    }
}
