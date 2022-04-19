package racingcar.model;

public class CarName {
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;
    private static final String CAR_NAME_MAXIMUM_LENGTH_EXCEEDED_ERR_MSG = "자동차의 이름은 5자를 초과할 수 없습니다.";
    private String name;

    public CarName(String name) {
        if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalStateException(CAR_NAME_MAXIMUM_LENGTH_EXCEEDED_ERR_MSG);
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
