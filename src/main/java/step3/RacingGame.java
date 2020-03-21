package step3;

public class RacingGame {

    private int time;
    private int[] carPositions;

    private static final int FORWARD_STATUS_VALUE = 4;
    private static final int FORWARD_VALUE = 1;
    private static final int STOP_VALUE = 0;

    public RacingGame() {
    }

    public RacingGame(int moveCount, int carCount) {
        time = moveCount;
        carPositions = new int[carCount];
    }

    public void moveByRepeatCount(int[] totalRandomNumber) {
        int length = carPositions.length;
        int[] randomNumber = new int[length];

        for (int i = 0; i < totalRandomNumber.length; i++) {
            randomNumber[i % length] = totalRandomNumber[i];
            if ((i + 1) % length == 0) {
                carPositions = move(randomNumber);
                randomNumber = new int[length];
            }
        }
    }

    public int[] move(int[] randomNumber) {
        for (int i = 0; i < carPositions.length; i++) {
            carPositions[i] += findOutMove(randomNumber[i]);
        }
        return carPositions;
    }

    public int findOutMove(int randomNumber) {
        return forwardStatus(randomNumber);
    }

    public int forwardStatus(int randomNumber) {
        if (randomNumber < FORWARD_STATUS_VALUE) {
            return STOP_VALUE;
        }
        return FORWARD_VALUE;
    }

    public int[] getCarPositions() {
        return carPositions;
    }
}
