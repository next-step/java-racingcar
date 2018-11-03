package racing;

import java.util.Arrays;

public class RacingGame {
    private RandomMoveGenerator moveNumberGenerator = null;
    private int times;
    private int[] carPositions = null;

    private final int MOVE_CONDTION = 4;
    private final int FINISH = 0;

    public RacingGame(int time, int cars) {
        this.times = time;
        this.carPositions = new int[cars];
        this.moveNumberGenerator = new RandomMoveGenerator();
    }

    public int[] move() {
        for (int i = 0; i < carPositions.length; i++) {
            int value = generateMoveNumber();
            if (canMove(value)) {
                carPositions[i]++;
            }
        }

        decreaseTimes();
        return carPositions;
    }

    public void setMoveNumberGenerator(RandomMoveGenerator moveNumberGenerator) {
        this.moveNumberGenerator = moveNumberGenerator;
    }

    public int[] getCarsPositions() {
        return Arrays.copyOf(carPositions, carPositions.length);
    }

    public boolean isFinish() {
        return times == FINISH;
    }

    private void decreaseTimes() {
        --times;
    }

    private boolean canMove(int value) {
        return value >= MOVE_CONDTION;
    }

    private int generateMoveNumber() {
        return moveNumberGenerator.generate();
    }

}