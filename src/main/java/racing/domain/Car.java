package racing.domain;


/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_AVAILABLE_BOUND = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        validCarNameLength(name);
        this.name = name;
        this.position = position;
    }

    public Car(Car car) {
        this.name = car.name;
        this.position = car.position;
    }

    private void validCarNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("앞,뒤 공백을 제외한 이름의 길이는 1~5의 길이만 가능합니다.");
        }
    }

    public void move(int randomNo) {
        if (canMove(randomNo)) {
            increasePosition();
        }
    }

    private boolean canMove(int randomNo) {
        return MOVE_AVAILABLE_BOUND <= randomNo;
    }

    private void increasePosition() {
        this.position ++;
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }
}
