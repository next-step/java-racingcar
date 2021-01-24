package racingcar;

import java.util.List;

class MockCars extends Cars {
    public int doRoundCallCnt;
    public int printWinnersCallCnt;

    public MockCars(List<Car> cars, MoveChecker moveChecker) {
        super(cars, moveChecker);

        doRoundCallCnt = 0;
        printWinnersCallCnt = 0;
    }

    @Override
    public void doRound() {
        doRoundCallCnt++;
    }

    @Override
    public void printWinners() {
        printWinnersCallCnt = doRoundCallCnt;
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



