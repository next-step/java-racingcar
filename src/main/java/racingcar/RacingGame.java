package racingcar;

import java.util.ArrayList;

public class RacingGame {

    // 시작 위치
    public final static int BASE_POSITION = 1;
    // 램덤값이 해당 값 이상일때만 move
    private final static int MORE_THAN_VALUE_FOR_CAR_MOVE = 4;

    private ArrayList<Integer> carPositions;

    public RacingGame(int carTotalCount) {
        validateCarTotalCount(carTotalCount);
        initCarPositions(carTotalCount);
    }

    public void startRacing(int runCount) {
        validateRunCount(runCount);
        for (int i = 0; i < runCount; i++) {
            moveCar();
        }
    }

    public void moveCar(){

    }

    private void initCarPositions(int carTotalCount) {
        this.carPositions = new ArrayList<>();
        for (int i = 0; i < carTotalCount; i++) {
            this.carPositions.add(BASE_POSITION);
        }
    }

    private void validateRunCount(int runCount) {
        if (runCount <= 0) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해야 합니다.");
        }
    }

    private void validateCarTotalCount(int carTotalCount) {
        if (carTotalCount <= 0) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해야 합니다.");
        }
    }
}
