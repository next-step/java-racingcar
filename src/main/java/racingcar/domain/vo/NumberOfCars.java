package racingcar.domain.vo;

public class NumberOfCars {
    private final int value;

    private NumberOfCars(final int value) {
        this.value = value;
    }

    public static NumberOfCars from(final int numberOfCar) {
        if (numberOfCar < 1) {
            throw new RuntimeException("자동차는 1대 이상이어야 합니다");
        }

        return new NumberOfCars(numberOfCar);
    }

    public int getValue() {
        return value;
    }
}
