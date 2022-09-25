package step3.model;

import step3.util.numberGenerator.NumberGenerator;

public class Car {
    private int moveCnt;
    private static final int MOVE_STANDARD = 4;

    public Car() {
        this.moveCnt = 0;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public void decideMoveOrStop(NumberGenerator numberGenerator) {
        int number = numberGenerator.generate();
        if (number > 9) throw new RuntimeException("경주에 필요한 값을 넘어섰습니다.");
        if (number >= MOVE_STANDARD) {
            this.moveCnt += 1;
        }
    }
}
