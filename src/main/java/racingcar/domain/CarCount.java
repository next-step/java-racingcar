package racingcar.domain;

public class CarCount extends NumberValidation {
    public final int carCount;

    public CarCount(int carCount) {
        this.carCount = isValid(carCount);
    }
}
