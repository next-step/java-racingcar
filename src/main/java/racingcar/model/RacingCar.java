package racingcar.model;

import racingcar.model.movestrategy.MoveStrategy;
import racingcar.model.movestrategy.RandomVarMoveStrategy;

public class RacingCar {
    private MoveStrategy moveStrategy;
    private Position position;
    private CarName name;

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
        this.position = new Position(this.position.step());
    }


    public CarName name() {
        return this.name;
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
