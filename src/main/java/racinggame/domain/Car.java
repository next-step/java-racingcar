package racinggame.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERR_MAX_NAME_LENGTH = "자동차 이름은 5글자를 초과할 수 없습니다.";

    private final String name;
    private int status;

    public Car(String name) {
        this.name = limitNameLength(name);
        this.status = 0;
    }

    public Car(String name, int status) {
        this(name);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            status++;
        }
    }

    private String limitNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException(ERR_MAX_NAME_LENGTH);
        }
        return name;
    }

}
