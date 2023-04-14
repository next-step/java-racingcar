package game.domain;

public class CarName {

    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private final String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 필수 입니다.");
        }
        if (carName.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException(String.format("자동차 이름은 5자를 초과할 수 없습니다.(%s)", carName));
        }
    }

    public String getName() {
        return name;
    }

}