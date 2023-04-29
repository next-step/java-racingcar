package racingcar.domain;

public class CarName {

    private static final int FIVE = 5;
    private static final String CANNOT_ABOVE_FIVE_LETTERS = "자동차 이름은 5자를 초과할 수 없습니다.";
    private final String carName;

    public CarName(String carName) {
        isAboveFiveLetters(carName);
        this.carName = carName;
    }

    public String getStringCarName() {
        return carName;
    }

    private static void isAboveFiveLetters(String carName) {
        if (carName.length() > FIVE) {
            throw new IllegalArgumentException(CANNOT_ABOVE_FIVE_LETTERS);
        }
    }
}