package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

class MockCars extends Cars {
    public int doRoundCallCnt;

    public MockCars(List<Car> cars, MoveChecker moveChecker) {
        super(cars, moveChecker);

        doRoundCallCnt = 0;
    }

    @Override
    public void doRound() {
        doRoundCallCnt++;
    }

    @Override
    public List<String> getWinners() {
        return new ArrayList<String>() {{
            add("fake winner");
        }};
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



