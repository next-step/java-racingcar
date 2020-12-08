package racing;

public class Car {
    private static final String WRONG_INPUT_CAR_NAME = "자동차의 이름은 5자를 초과할 수 없습니다";
    private static final int MOVING_CONDITION_COUNT = 3;
    private static final int MOVING_DISTANCE = 1;
    private final MovingCondition movingCondition;

    private int position;
    private final String name;

    public Car(MovingCondition condition, String carName) {
        movingCondition = condition;
        carValidation(carName);
        name = carName;
    }

    public int getPosition() {
        return position;
    }

    public String carName() {
        return name;
    }

    public void move() {
        position = movingCondition.getCondition() > MOVING_CONDITION_COUNT ? position + MOVING_DISTANCE : position;
    }

    public void carValidation(String carName) {
        if (isNotAvailableCarName(carName)) {
            throw new IllegalArgumentException(WRONG_INPUT_CAR_NAME);
        }
    }

    private boolean isNotAvailableCarName(String carName) {
        return carName.length() > 5;
    }
}
