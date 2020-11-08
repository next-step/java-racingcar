package racingcar.step3.domain;

import racingcar.step3.common.Consts;

/**
 * Created : 2020-11-02 오전 8:32
 * Developer : Seo
 */
public class Car {
    private int distance;

    public void move(int random) {
        if (random > Consts.WHEN_THE_VALUE_IS_OVER_THREE) {
            this.distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
