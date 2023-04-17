package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class RacingCar {
    private static final int MOVEMENT_DISTANCE = 1;     // 자동차 이동 시 1만큼 전진
    private int position = 0;                           // 차가 이동한 위치
    private String carName;                    // 차가 이동한 위치

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public void tryToMove(MoveStrategy moveStrategy) {
        if (moveStrategy.decideMoveOrHold()) {
            this.position += MOVEMENT_DISTANCE;
        }
    }

    public int position() {
        return this.position;
    }

    public String name() {
        return this.carName;
    }
}
