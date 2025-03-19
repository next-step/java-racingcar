package racingcar.racing;


import racingcar.movepolicy.MoveStrategy;

public class Car {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;
    private final MoveStrategy moveStrategy;
    private Integer distance = 0;

    public Car(String name, MoveStrategy moveStrategy) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
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