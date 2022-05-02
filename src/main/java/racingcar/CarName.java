package racingcar;

public class CarName {
    private String name;

    public CarName(String name) {
        validateCarNames(name);
        this.name = name;
    }

    private static void validateCarNames(String carName) {
        validateLength(carName);
    }

    private static void validateLength(String carName) throws IllegalStateException {
        if (carName.length() > 5) {
            throw new IllegalStateException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
