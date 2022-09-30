package step3.model;

import step3.util.numberGenerator.NumberGenerator;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private static final int MAX_BOUND = 9;
    private static final int MIN_BOUND = -1;

    private int moveCnt;

    public Car() {
        this.moveCnt = 0;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public void decideMoveOrStop(int generatedNumber) {
        if (generatedNumber > MAX_BOUND || generatedNumber < MIN_BOUND) throw new RuntimeException("생성된 숫자가 경주에 필요한 값의 범위를 벗어났습니다.");
        if (generatedNumber >= MOVE_STANDARD) this.moveCnt += 1;
    }
}
