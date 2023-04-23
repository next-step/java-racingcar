package racing.domain;


/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class Car {
    private static final int DEFAULT_LOCATION = 0;
    private static final int MOVE_AVAILABLE_BOUND = 4;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int location;

    public Car(String name) {
        validCarName(name);
        this.name = name;
        this.location = DEFAULT_LOCATION;
    }

    private void validCarName(String name) {
        String trim = name.trim();
        if (trim.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < trim.length()) {
            throw new IllegalArgumentException("앞,뒤 공백을 제외한 이름의 길이는 1~5의 길이만 가능합니다.");
        }
    }

    public Car(Car car) {
        this.name = car.name;
        this.location = car.location;
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
