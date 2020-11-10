package racingcar.step3.domain;

import racingcar.step3.common.Consts;

/**
 * Created : 2020-11-02 오전 8:32.
 * Developer : Seo.
 */
public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public void move(int random) {
        if (random > Consts.INVALID_VALUE) {
            this.distance++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

}
