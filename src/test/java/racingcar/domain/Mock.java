package racingcar.domain;

import java.util.List;

class MockCars extends Cars {
    public int playCnt;

    public MockCars(List<Car> cars, MoveChecker moveChecker) {
        super(cars, moveChecker);
        playCnt = 0;
    }

    @Override
    public void doRound() {
        playCnt++;
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



