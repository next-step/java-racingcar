package racing;

import java.util.Random;

public class RacingGame {
    private Random random = new Random();
    private int times;
    private int[] carPositions = null;
    private STATUS status;


    public RacingGame(int time, int cars) {
        this.times = time;
        this.carPositions = new int[cars];
        changeStatus(STATUS.READY);
    }

    public int[] move() {
        if (isFinish()) {
            throw new RuntimeException("Racing Game is finish.");
        }

        for (int i = 0; i < carPositions.length; i++) {
            if (canMove()) {
                carPositions[i]++;
            }
        }

        decreaseTimes();
        changeStatus( times > 0 ? STATUS.RACING : STATUS.FINISH );
        return carPositions;
    }

    public boolean isFinish() {
        return STATUS.FINISH == status;
    }

    public boolean isReady() {
        return STATUS.READY == status;
    }

    public boolean isRacing() {
        return STATUS.RACING == status;
    }

    private void decreaseTimes() {
        --times;
    }

    private boolean canMove() {
        return random.nextInt(10) > 3 ? true : false;
    }

    private void changeStatus(STATUS newStatus) {
        status = newStatus;
    }

}