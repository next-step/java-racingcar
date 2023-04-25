package racing.domain;


/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class Car {
    private static final int DEFAULT_LOCATION = 0;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_AVAILABLE_BOUND = 4;

    private final String name;
    private int location;

    public Car(String name) {
        this(name, DEFAULT_LOCATION);
    }

    public Car(String name, int location) {
        String trimmedName = name.trim();
        validCarName(trimmedName);
        this.name = trimmedName;
        this.location = location;
    }

    public Car(Car car) {
        this.name = car.name;
        this.location = car.location;
    }

    private void validCarName(String trimmedName) {
        if (validNameLength(trimmedName)) {
            throw new IllegalArgumentException("앞,뒤 공백을 제외한 이름의 길이는 1~5의 길이만 가능합니다.");
        }
    }

    private boolean validNameLength(String trimmedName) {
        return trimmedName.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < trimmedName.length();
    }

    public void move(int distance) {
        if (canMove(distance)) {
            changeLocation(distance);
        }
    }

    private boolean canMove(int distance) {
        return MOVE_AVAILABLE_BOUND <= distance;
    }

    private void changeLocation(int distance) {
        this.location += distance;
    }

    public String name() {
        return this.name;
    }

    public int location() {
        return this.location;
    }
}
