package racingcar.model;

public class Name {
    private static final String CAR_NAME_LONGER_THAN_FIVE = "[ERROR] 자동차 이름은 5글자를 초과할 수 없습니다.";
    private static final String CAR_NAME_LESS_THAN_ONE = "[ERROR] 자동차 이름은 최소 1글자 이상이어야 합니다. ";
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String name;
    public Name(String name){
        this.name=validateCarNameLength(name);
    }

    private String validateCarNameLength(String name) {
        if (name.length() < MINIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LESS_THAN_ONE);
        }
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LONGER_THAN_FIVE);
        }

        return name;
    }

    public String getCarName() {
        return name;
    }
}
