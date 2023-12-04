package racingcar.model;

import racingcar.model.movestrategy.MoveStrategy;
import racingcar.model.movestrategy.RandomVarMoveStrategy;

public class RacingCar {
    private final CarName name;
    private final MoveStrategy moveStrategy;
    private Position position;

    public RacingCar(String name) {
        this(new RandomVarMoveStrategy(), name);
    }

    public RacingCar(MoveStrategy moveStrategy, String name) {
        // set MoveStrategy
        this.moveStrategy = moveStrategy;

        // setting
        this.name = new CarName(name);
        this.position = new Position();
    }


    public void moveOrStop() {
        if (moveStrategy.canMove()) {
            this.move();
        }
    }

    private void move() {
        this.position = this.position.increase();
    }


    public String name() {
        return this.name.toString();
    }

    public Position position() {
        return this.position;
    }

    @Override
    public boolean equals(Object obj) {
        RacingCar other = (RacingCar) obj;
        if (this.name == other.name
                && this.moveStrategy == other.moveStrategy
                && this.position == other.position) {
            return true;
        }
        return false;
    }
}
