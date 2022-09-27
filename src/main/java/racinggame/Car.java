package racinggame;

public class Car {
    private int status;
    private String name;

    private static final int MAX_NUMBER = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERR_MAX_NAME_LENGTH = "자동차 이름은 5글자를 초과할 수 없습니다.";

    public Car() {}

    public Car(String name) {
        this.name = limitNameLength(name);
        this.status = 0;
    }

    public void forward() {
        this.status++;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void move(int number) {
        if (number >= MAX_NUMBER) {
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
