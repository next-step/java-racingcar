package racingcar;

public class Car {

    private String name;
    private Integer position = 0;
    private static final Integer MOVE_MINIMUM_CONDITION = 4;
    private static final Integer MOVE_MAXIMUM_CONDITION = 9;
    private static final Integer CAR_NAME_MAXIMUM_LENGTH_CONDITION = 5;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void move(RandomValueGenerator randomValueGenerator) {
        if (judgeForth(randomValueGenerator.generate())) {
            position++;
        }
    }

    private boolean judgeForth(int degree) {
        return (degree >= MOVE_MINIMUM_CONDITION) && (degree <= MOVE_MAXIMUM_CONDITION);
    }

    private void validateNameLength(String name) {
        if (checkNameCondition(name)) {
            throw new IllegalArgumentException("차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private boolean checkNameCondition(String name) {
        return name.length() > CAR_NAME_MAXIMUM_LENGTH_CONDITION;
    }

    public int showNowPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
