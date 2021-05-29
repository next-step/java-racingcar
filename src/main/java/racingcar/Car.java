package racingcar;

public class Car {
    private static final int NAME_LENGTH_LIMIT_VALUE = 5;
    private static final int MOVING_STANDARD_VALUE = 4;
    private final String name;
    int position;

    public Car(String name) {
        this(name,0);
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public void go(int number) {
        if (movable(number)) {
            position += 1;
        }
    }

    private boolean movable(int number) {
        return number >= MOVING_STANDARD_VALUE;
    }

    private void validateName(String name){
        if (name.length() > NAME_LENGTH_LIMIT_VALUE) {
            throw new IllegalArgumentException("이름 길이가 5를 초과합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
