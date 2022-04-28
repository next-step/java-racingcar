package study.step4.try3.domain;

public class CarName {
    private static final int LIMITED_STRING_LENGTH = 5;
    private final String carName;

    private CarName(String carName) {
        this.carName = carName;
    }

    public static CarName of(String carName) {
        if (isInvalid(carName)) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
        return new CarName(carName);
    }

    public String getCarName() {
        return carName;
    }

    private static boolean isInvalid(String carName) {
        if (carName.isEmpty() || carName == null) {
            return true;
        }
        if (carName.length() > LIMITED_STRING_LENGTH) {
            return true;
        }
        return false;
    }
}
