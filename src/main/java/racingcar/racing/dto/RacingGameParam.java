package racingcar.racing.dto;

public class RacingGameParam {
    int carNumber;
    int tryNumber;

    public RacingGameParam(int carNumber, int tryNumber) {
        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
