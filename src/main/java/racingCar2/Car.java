package racingCar2;

public class Car {
    private static final int LIMIT_VALUE = 5;
    private static final int FORWARD_VALUE = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    public boolean isGreaterThanFive(int number) {
        return number > LIMIT_VALUE;
    }

    public void validate(String name) {
        if (isGreaterThanFive(name.length())) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과합니다.");
        }
    }

    public static boolean movable(int number) {
        return number >= FORWARD_VALUE;
    }

    public String getName() {
        return name;
    }

    public void go(int number) {
        if (movable(number)) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

}
