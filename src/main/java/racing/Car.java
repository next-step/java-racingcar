package racing;

public class Car {

    private static final int NAME_LENGTH = 5;
    private static final int MOVE_CHECK_NUMBER = 4;
    private String name;
    private int distance;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void move(int moveNum) {
        if (moveNum >= MOVE_CHECK_NUMBER) {
            distance++;
        }
    }

    public static int getMoveRandomNumber() {
        return (int) ((Math.random() * (10)));
    }
}
