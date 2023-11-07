package racing.domain;

public class Car {
    private final int MOVE_THRESHOLD = 4;
    private final int MAX_USER_NAME_LENGTH = 5;
    private final Position position;

    private final String userName;

    public Car() {
        this.position = new Position(0);
        this.userName = null;
    }

    public Car(String userName) {
        this.position = new Position(0);
        validateUserNameLength(userName);
        this.userName = userName;
    }

    public int getPosition() {
        return this.position.getValue();
    }

    public String getUserName() {
        return userName;
    }

    public void move(int input) {
        if (isMovable(input)) {
            position.setValue(position.getValue() + 1);
        }
    }

    private boolean isMovable(int input) {
        return input >= MOVE_THRESHOLD;
    }

    private void validateUserNameLength(String userName) {
        if (userName.length() > MAX_USER_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
