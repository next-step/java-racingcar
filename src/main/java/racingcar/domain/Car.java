package racingcar.domain;

public class Car {

    private static final int CONDITION_NUMBER = 4;
    private int forwardCnt;
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public void moveForward(int randomNumber) {
        if(ableMove(randomNumber))
            forwardCnt++;
    }
public void moveForward() {
        forwardCnt++;
}
    private boolean ableMove(int randomNumber) {
        return randomNumber >= CONDITION_NUMBER;
    }

    public int forwardCnt() {
        return forwardCnt;
    }

    public String carName() {
        return carName;
    }

    public boolean matchPosition(int maxPosition){
        return forwardCnt == maxPosition;
    }
}
