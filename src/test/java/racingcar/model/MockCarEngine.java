package racingcar.model;

import racingcar.logic.CarEngine;

public class MockCarEngine implements CarEngine {

    private Boolean move;

    public MockCarEngine(Boolean move) {
        this.move = move;
    }

    @Override
    public boolean isMove() {
        return move;
    }
}
