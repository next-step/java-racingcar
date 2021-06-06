package carracing;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private static final int NAME_LIMIT = 5;
    private static final int POSITION_INITIAL_VALUE = 0;
    private static final String CAR_NAME_EXCEPTION_MESSAGE = "자동차 이름이 5자 이상입니다";

    private String carName;
    private int position;

    Car(String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
        this.position = POSITION_INITIAL_VALUE;
    }

    public void validateCarNameLength(String carName) {
        if (carName.length() >= NAME_LIMIT) {
            throw new IllegalArgumentException(CAR_NAME_EXCEPTION_MESSAGE);
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            this.position++;
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
