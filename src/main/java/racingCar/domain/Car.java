package racingCar.domain;

import static racingCar.RacingCarUtils.checkCarNameRule;

public class Car implements Comparable<Car> {
    private Position curPosition;
    private String name;

    public Car(String name) {
        checkCarNameRule(this.name = name);
        curPosition = new Position();
    }

    public void racing(int randomValue, MoveStrategy moveStrategy) {
        if(moveStrategy.isMove(randomValue)) {
            curPosition.move();
        }
    }

    public Position getPosition() {
        return curPosition;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return this.curPosition.compareTo(o.curPosition);
    }
}
