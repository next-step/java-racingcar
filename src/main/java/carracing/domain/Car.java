package carracing.domain;

public class Car {

    private static final int MOVE_NUMBER = 4;
    private static final int NAME_LIMIT_LENGTH = 5;

    private int location;

    private final String name;

    public Car(String name) {
        checkNameLength(name);

        this.location = 0;
        this.name = name;
    }

    public int location() {
        return location;
    }

    public String name() {
        return name;
    }

    public void forward() {
        this.location++;
    }

    public boolean isMovable(int cmd) {
        return cmd >= MOVE_NUMBER;
    }

    public int move(int cmd) {
        if (isMovable(cmd)) {
            forward();
        }
        return this.location;
    }

    public void checkNameLength(String name) {
        if (name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + NAME_LIMIT_LENGTH + " 이하여야 합니다.");
        }
    }
}
