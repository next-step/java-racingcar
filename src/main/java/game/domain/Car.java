package game.domain;

public class Car {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;
    private static final int MINIMUM_MOVEMENT_NUMBER = 4;
    private final String name;
    private int distance = 1;

    public Car(String name) {
        this.name = name;
        validateName();
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void move(int number) {
        validateNumber(number);
        if (canMove(number)) {
            distance += 1;
        }
    }

    private void validateName() {
        if (this.name == null || "".equals(this.name) || this.name.length() > 5) {
            throw new RuntimeException();
        }
    }

    private void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new RuntimeException();
        }
    }

    private boolean canMove(int number) {
        return number >= MINIMUM_MOVEMENT_NUMBER;
    }
}
