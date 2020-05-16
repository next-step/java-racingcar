package util;

import racingcar.Racingcar;

public class RacingCarComparator implements java.util.Comparator<Racingcar> {

    @Override
    public int compare(Racingcar racingcar1, Racingcar racingcar2) {
        return Integer.compare(racingcar2.getCarMovePosition(), racingcar1.getCarMovePosition());
    }
}
