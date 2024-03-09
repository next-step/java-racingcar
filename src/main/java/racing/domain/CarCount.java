package racing.domain;

public class CarCount {
    private final int numberOfRacingCar;

    public CarCount(String input) {
        this.numberOfRacingCar = toInt(input);
    }

    public int getNumberOfRacingCar() {
        return numberOfRacingCar;
    }

    private int toInt(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException();
        }

        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (isZeroOrNegativeNumber(number)) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    private boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }

    private boolean isZeroOrNegativeNumber(int number) {
        return number <= 0;
    }
}
