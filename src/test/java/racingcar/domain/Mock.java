package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

class MockCars extends Cars {
    public MockCars(List<Car> cars, MoveChecker moveChecker) {
        super(cars, moveChecker);
    }

    @Override
    public ResultWinners getWinners() {
        return null;
    }

    @Override
    public ResultRound getNextRound() {
        return null;
    }
}

class FalseMoveChecker extends MoveChecker {
    @Override
    public boolean isMoving() {
        return false;
    }
}

class TrueMoveChecker extends MoveChecker {
    @Override
    public boolean isMoving() {
        return true;
    }
}

class TrueFalseRepeatChecker extends MoveChecker {
    private boolean isMove = false;

    @Override
    public boolean isMoving() {
        isMove = !isMove;
        return isMove;
    }
}



