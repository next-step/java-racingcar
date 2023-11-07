package racingcar.domain;

public class Car {
    private int forwardCnt;
    private int randomNumber;
    private static final int CONDITION_NUMBER = 4;

    public Car(int forwardCnt, int randomNumber) {
        this.forwardCnt = forwardCnt;
        this.randomNumber = randomNumber;
    }

    public void moveForward() {
        if (randomNumber >= CONDITION_NUMBER) {
            forwardCnt++;
        }
    }

    public int getForwardCnt() {
        return forwardCnt;
    }
}
