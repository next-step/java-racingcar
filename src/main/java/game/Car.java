package game;

public class Car {
    private static final int MOVE_FLAG = 4;
    private int movingCount;

    public int getMovingCount() {
        return movingCount;
    }

    private void increaseMovingCount() {
        this.movingCount++;
    }

    public void move(int randomValue) {
        if (isMove(randomValue)) {
            this.increaseMovingCount();
        }
    }

    private boolean isMove(int randomValue) {
        return MOVE_FLAG <= randomValue;

    }

}
