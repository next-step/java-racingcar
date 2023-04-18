package racingcar;

import java.util.Random;

public class RacingCar {

    private static final int RANDOM_BOUND = 10;
    private static final int CAR_PROCEED_THRESHOLD = 4;
    private static final int INIT_POSITION_ONE = 1;

    private final Random random = new Random();

    private final int[][] carPositions;

    RacingCar(int carCount, int trialCount) {
        carPositions = new int[carCount][trialCount];
    }

    public void startRace() {
        initializePositions();
        updatePositions();
    }

    public void initializePositions() {
        for(int[] row : carPositions) {
            row[0] = INIT_POSITION_ONE; // 출발점이 1인 것 같아서 1로 초기화했다.
        }
    }

    public void updatePositions() {
        for(int[] positions : carPositions) {
            for(int i = 1; i < positions.length; i++) {
                positions[i] += positions[i - 1] + proceedOrStop();
            }
        }
    }

    public int proceedOrStop() {
        int randomValue = random.nextInt(RANDOM_BOUND);
        return randomValue >= CAR_PROCEED_THRESHOLD ? 1 : 0;
    }

    int[][] getCarPositions() {
        return carPositions;
    }
}
