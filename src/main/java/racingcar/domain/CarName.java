package racingcar.domain;

public class CarName {
    private final String name;

    private static final int CAR_NAME_THRESHOLD = 5;

    private static final String CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 5자를 초과할 수 없습니다.";

    public CarName(String name) {
        this.name = name;
    }

    public static CarName valueOf(String name) throws IllegalArgumentException {
        validateCarNames(name);
        return new CarName(name);
    }

    private static void validateCarNames(String name) throws IllegalArgumentException {
        if (isOverThreshold(name)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION);
        }
    }

    private static boolean isOverThreshold(String name) {
        return name.length() > CAR_NAME_THRESHOLD;
    }

    public String getName() {
        return this.name;
    }
}
