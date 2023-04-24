package racingcar.domain;

public class CarName {

    private final int CAR_NAME_MAXIMUM_LENGTH_CONDITION = 5;
    private final String EXPLANATION_VALIDATION_NAME = "차 이름은 5글자를 초과할 수 없습니다.";
    private String name;

    public CarName(String name) {
        this.validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (checkNameCondition(name)) {
            throw new IllegalArgumentException(EXPLANATION_VALIDATION_NAME);
        }
    }

    private boolean checkNameCondition(String name) {
        return name.length() > CAR_NAME_MAXIMUM_LENGTH_CONDITION;
    }

    public String getName() {
        return name;
    }
}
