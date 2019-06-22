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

    private final int winScore;
    private Cars winner;

    public Winner(Cars winner, int winScore) {
        this.winner = winner;
        this.winScore = winScore;
    }

    public static Winner checkPosition(List<Car> candinateWinner) {
        List<Integer> positionList = candinateWinner.stream()
                .map(Car::getCarPosition)
                .collect(Collectors.toList());

        int maxPosition = getMaxPosition(positionList);

        List<Car> winners = candinateWinner.stream()
                .filter(car -> car.getCarPosition() == maxPosition)
                .collect(Collectors.toList());

        return new Winner(new Cars(winners), maxPosition);
    }

    public static int getMaxPosition(List<Integer> positionList) {
        return positionList.stream()
                .max(Integer::compare)
                .get();
    }

    public List<String> getCarNames() {
        return this.winner.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
