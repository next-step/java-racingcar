package racing.domain;

public class Car {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int STANDARD_NUMBER_MOVE_FORWARD = 4;
    private static final String SEPARATOR_BETWEEN_NAME_AND_POSITION = " : ";
    private static final String MOVE_STATE = "-";

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
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

    private boolean isSamePosition(final int position) {
        return this.position == position;
    }

    public void drive(int randomNumber) {
        if (isMovable(randomNumber)) {
            this.position++;
        }
        printStatus();
    }

    private boolean isMovable(final int randomNumber) {
        return randomNumber >= STANDARD_NUMBER_MOVE_FORWARD;
    }

    private void printStatus() {
        System.out.print(name + SEPARATOR_BETWEEN_NAME_AND_POSITION);
        for (int i = 0; i < position; i++) {
            System.out.print(MOVE_STATE);
        }
        System.out.println();
    }

    public int getPosition() {
        return position;
    }
}
