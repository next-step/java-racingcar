package racing.domain;

public class Car {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int STANDARD_NUMBER_MOVE_FORWARD = 4;
    private static final int RANGE_OF_RANDOM_NUMBER = 10;

    private final String name;
    private int position;

    public Car(final String name) {
        checkNameLength(name);
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    private static void checkNameLength(final String name) {
        if (name.length() < CAR_NAME_MIN_LENGTH || name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(
                "[ERROR] 이름의 길이는 " + CAR_NAME_MIN_LENGTH + " ~ " + CAR_NAME_MAX_LENGTH
                    + " 글자 까지만 가능합니다.");
        }
    }

    public String checkSamePosition(final int position) {
        if (this.position == position) {
            return name;
        }
        return "";
    }

    public void drive() {
        final int randomNumber = generateRandomNumber();
        if (isMove(randomNumber)) {
            this.position++;
        }
        printStatus();
    }

    private boolean isMove(final int randomNumber) {
        return randomNumber >= STANDARD_NUMBER_MOVE_FORWARD;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

    private void printStatus() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
