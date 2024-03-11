package racinggame.domain;

public class CarsCount {

    private int carsCount;

    public CarsCount(int carsCount) {
        validationCarsCount(carsCount);
        this.carsCount = carsCount;
    }

    private void validationCarsCount(int carsCount) {
        if (isNegativeValue(carsCount)) {
            throw new IllegalArgumentException("자동차 대수가 음수 입력입니다: " + carsCount);
        }
    }

    private boolean isNegativeValue(int carsCount) {
        return carsCount < 0;
    }

    public int value() {
        return carsCount;
    }
}
