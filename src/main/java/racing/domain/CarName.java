package racing.domain;

public class CarName {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ERROR_MESSAGE_FOR_OVER_CAR_NAME_LENGTH = "자동차의 이름은 5자를 넘을 수 없습니다.";
    private static final String ERROR_MESSAGE_FOR_BLANK_CAR_NAME = "자동차의 이름은 1자 이상이여야 합니다.";

    private final String name;

    public CarName(String name) {
        this.name = name;
    }

    public static CarName checkCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_OVER_CAR_NAME_LENGTH);
        }
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_BLANK_CAR_NAME);
        }
        return new CarName(carName);
    }

    public String getName() {
        return name;
    }
}
