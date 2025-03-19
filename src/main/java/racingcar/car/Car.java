package racingcar.car;


import racingcar.movepolicy.MoveStrategy;

public class Car {

    private final MoveStrategy moveStrategy;
    private Integer distance = 0;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public Integer getDistance() {
        return distance;
    }

    public void play() {
        if (moveStrategy.move()) {
            distance++;
        }
    }
}