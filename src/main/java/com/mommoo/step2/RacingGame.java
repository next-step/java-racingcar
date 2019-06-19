package com.mommoo.step2;

public class RacingGame {
    private final int[] CAR_POSITIONS;
    private final RacingCarMovingConditioner movingConditioner = new RacingCarMovingConditioner();

    public RacingGame(int carCount) {
        this.CAR_POSITIONS = new int[carCount];
    }

    public int[] move() {
        int size = CAR_POSITIONS.length;
        int[] returnPositions = new int[size];

        for (int index = 0; index < size ; index++) {
            boolean isMoving = movingConditioner.isMoveCondition();
            if (isMoving) {
                CAR_POSITIONS[index] += 1;
            }
            returnPositions[index] = CAR_POSITIONS[index];
        }

        return returnPositions;
    }
}
