package racing.domain;

import racing.rule.move.MoveStrategy;

public class Car {
    private final static int CAR_NAME_MAX_LENGTH = 5;
    private final String carName;
    private int forwardCount = 1;

    public Car(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("차량명은 5자를 넘을 수 없습니다.");
        }
        this.carName = carName;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            this.forwardCount++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}