package racingcar.model;

import racingcar.model.movestrategy.MoveStrategy;
import racingcar.model.movestrategy.RandomVarMoveStrategy;

public class RacingCar {
    private static final String ERR_NAME_LENGTH = "Names longer than 5 characters are not allowed.";
    private static final int NAME_MAX_LENGTH = 5;

    private MoveStrategy moveStrategy;
    private Position position;
    private String name;

    public RacingCar(String name) {
        // set MoveStrategy
        this.moveStrategy = new RandomVarMoveStrategy();

        // validation
        validateCarName(name);

        // setting
        this.name = name;
        this.position = new Position();
    }

    public RacingCar(MoveStrategy moveStrategy, String name) {
        // set MoveStrategy
        this.moveStrategy = moveStrategy;

        // validation
        validateCarName(name);

        // setting
        this.name = name;
        this.position = new Position();
    }

    private void validateCarName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERR_NAME_LENGTH);
        }
    }


    public void moveOrStop() {
        if (moveStrategy.canMove()) {
            this.position.step();
        }
    }


    public String name() {
        return this.name;
    }

    public Position position() {
        return this.position;
    }
}
