package RacingCar.domain;

public class Car {
    private static int STANDARD_TO_MOVE_NUMBER = 4;
    private static int START_POSITION = 1;

    private String name;
    private int position;

    public Car(String name, int position) {
        carNameCheck(name);

        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, START_POSITION);
    }

    public void move(boolean isMove) {
        if (isMove) {
            position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    private void emptyCheck(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void carNameCheck(String name) {
        emptyCheck(name);
        nameLengthCheck(name);
    }

    private void nameLengthCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
