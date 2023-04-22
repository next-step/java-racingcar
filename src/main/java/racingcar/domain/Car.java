package racingcar.domain;

import racingcar.dto.RandomValueGenerator;

public class Car {

    private static final int MOVE_MINIMUM_CONDITION = 4;
    private static final int MOVE_MAXIMUM_CONDITION = 9;
    private CarName carName;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new Position(position);
    }

    public void move(RandomValueGenerator randomValueGenerator) {
        if (judgeForth(randomValueGenerator.generate())) {
            position.moveForth();   // todo
        }
    }

    private boolean judgeForth(int degree) {
        return (degree >= MOVE_MINIMUM_CONDITION) && (degree <= MOVE_MAXIMUM_CONDITION);
    }

    public int showNowPosition() {
        return position.showPosition();
    }

    public int chooseLongerDistance(int distanceMax) {
        return position.chooseLongerDistance(distanceMax);
    }

    public boolean isSameDistance(int distanceMax) {
        return position.isSamDistance(distanceMax);
    }

    public String getName() {
        return carName.getName();
    }

}
