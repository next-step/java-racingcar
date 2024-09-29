package racing.input;

import racing.exception.InvalidNumberException;

public class RaceInput {

    private final int numOfCar;
    private final int numOfAttempt;

    public RaceInput(int numOfCar, int numOfAttempt) {
        if (numOfCar < 1) {
            throw new InvalidNumberException("레이스 참가 차량 수는 1대 이상이여야 합니다.");
        }

        if (numOfAttempt < 1) {
            throw new InvalidNumberException("레이스 횟수는 1회 이상이여야 합니다.");
        }

        this.numOfCar = numOfCar;
        this.numOfAttempt = numOfAttempt;
    }

    public int getNumOfCar() {
        return numOfCar;
    }

    public int getNumOfAttempt() {
        return numOfAttempt;
    }
}
