package step3;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int MIN_MOVE_CONDITION = 4;
    //이동 횟수만큼 전진/멈춤 상태 저장
    private List<Boolean> moveHistory = new ArrayList<>();

    public void move() {
        //자동차의 랜덤 값을 구한다.
        int moveValue = generateMoveValue();
        //랜덤 값이 전진/멈춤인지 판단한다.
        boolean movable = isMovable(moveValue);
        //자동차 경주 상태에 해당 이동 상태를 포함해 저장한다.
        this.moveHistory.add(movable);
    }

    public Boolean findMoveAt(int idx) {
        if (idx < moveHistory.size()) {
            return moveHistory.get(idx);
        }
        return null;
    }

    private int generateMoveValue() {
        return RandomUtil.generateMoveValue();
    }

    private boolean isMovable(int moveValue) {
        if (moveValue < MIN_MOVE_CONDITION) {
            return false;
        }
        return true;
    }
}
