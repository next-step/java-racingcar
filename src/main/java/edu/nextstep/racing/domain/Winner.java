package edu.nextstep.racing.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 19:52
 */
public class Winner {

    private Cars winner;

    public Winner(Cars winner) {
        this.winner = winner;
    }

    public static Winner checkPosition(Cars candinateWinner) {
        List<Integer> positionList = candinateWinner.stream()
                .map(Car::getCarPosition)
                .collect(Collectors.toList());

        int maxPosition = getMaxPosition(positionList);

        Cars winners = new Cars(candinateWinner.stream()
                .filter(car -> car.comparePosition(maxPosition))
                .collect(Collectors.toList()));

        return new Winner(winners);
    }

    public static int getMaxPosition(List<Integer> positionList) {
        return positionList.stream()
                .max(Integer::compare)
                .get();
    }

    public CarNames getCarNames() {
        return this.winner.getCarNames();
    }
}
