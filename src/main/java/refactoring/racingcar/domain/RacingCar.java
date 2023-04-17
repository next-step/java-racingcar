package refactoring.racingcar.domain;

import refactoring.racingcar.strategy.MoveStrategy;

public class RacingCar implements Comparable<RacingCar> {
    private final MoveStrategy moveStrategy;
    private final Name name;
    private Position position;

    public RacingCar(MoveStrategy moveStrategy, String name) {
        this.moveStrategy = moveStrategy;
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public void move() {
        if (moveStrategy.shouldMove()) {
            this.position = position.plus();
        }
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(RacingCar o) {
        return position.compareTo(o.position);
    }
}
