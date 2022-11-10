package racing.domain;

public class CarName {
    private static final String NOT_EXCEED_CARNAME_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다.";

    private String carName;

    public CarName(String carName) {
        validateForString(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validateForString(String input) {
        if (input.length() > 5 || input.isBlank()) {
            throw new RuntimeException(NOT_EXCEED_CARNAME_LENGTH);
        }
    }
}