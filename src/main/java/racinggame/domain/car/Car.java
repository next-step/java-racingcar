package racinggame.domain.car;

import racinggame.util.NumberUtil;

/**
 * 1. 움직이는 거리 필드
 * 1. 자동차 이름 필드
 * 1. 게임 진행시 자동차 이동
 */
public class Car {
    private int moveRange = 0;
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    /**
     * 랜던값이 4보다 크면 자동차 한칸 이동
     */
    public void moveCar() {
        if (NumberUtil.isGreaterThan4((NumberUtil.createRandomIntIn0to9()))) {
            this.moveRange++;
        }
    }

    public int getMoveRange() {
        return moveRange;
    }

    public String getCarName() {
        return carName;
    }
}
