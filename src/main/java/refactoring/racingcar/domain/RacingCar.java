package refactoring.racingcar.domain;

import refactoring.racingcar.strategy.MoveStrategy;

public class RacingCar implements Comparable<RacingCar> {
    private final MoveStrategy moveStrategy;
    private final CarName name;
    private CarPosition position;

    public RacingCar(MoveStrategy moveStrategy, String name) {
        this.moveStrategy = moveStrategy;
        this.name = new CarName(name);
        this.position = new CarPosition(0);
    }

    public void move() {
        if (moveStrategy.shouldMove()) {
            this.position = position.plus();
        }
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getPosition() {
        return position;
    }

    @Override
    public int compareTo(RacingCar o) {
        return position.compareTo(o.position);
    }
}
