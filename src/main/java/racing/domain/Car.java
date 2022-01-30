package racing.domain;

public class Car {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int STANDARD_NUMBER_MOVE_FORWARD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
        checkNameLength(this.name);
    }

    private static void checkNameLength(final String name) {
        if (name.length() < CAR_NAME_MIN_LENGTH || name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(
                "[ERROR] 이름의 길이는 " + CAR_NAME_MIN_LENGTH + " ~ " + CAR_NAME_MAX_LENGTH
                    + " 글자 까지만 가능합니다.");
        }
    }

    public String getNameBy(int maxPosition) {
        if (isSamePosition(maxPosition)) {
            return this.name;
        }
        return "";
    }

    public boolean isSamePosition(final int position) {
        return this.position == position;
    }

    public void drive(int randomNumber) {
        if (isMovable(randomNumber)) {
            this.position++;
        }
    }

    private boolean isMovable(final int randomNumber) {
        return randomNumber >= STANDARD_NUMBER_MOVE_FORWARD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
