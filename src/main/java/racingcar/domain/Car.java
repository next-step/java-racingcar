package racingcar.domain;

public class Car {

    private static final int CONDITION_NUMBER = 4;
    private int forwardCnt;

    public Car() {
        this.forwardCnt = 0;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= CONDITION_NUMBER) {
            forwardCnt++;
        }
    }

    public int getForwardCnt() {
        return forwardCnt;
    }
}
