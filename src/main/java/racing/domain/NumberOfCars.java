package racing.domain;

public class NumberOfCars {
    private final int number;

    private NumberOfCars(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
        this.number = number;
    }

    public static NumberOfCars of(final int number) {
        return new NumberOfCars(number);
    }

    public int getNumber() {
        return number;
    }
}
