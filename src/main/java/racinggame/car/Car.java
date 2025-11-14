package racinggame.car;

public class Car {
    private int position;
    private String name;

    private static final int DEFAULT_POSITION = 0;
    private static final int PLUS_POSITION = 1;
    private static final int STANDARD_TO_ADVANCE = 4;

    public Car(String name) {
        this.position = DEFAULT_POSITION;
        this.name = name;
    }

    public void move(int inputValue) {
        if (isKeep(inputValue)) {
            return;
        }

        this.position += PLUS_POSITION;
    }

    private boolean isKeep(int inputValue) {
        return inputValue < STANDARD_TO_ADVANCE;
    }

    public boolean isSamePosition(int checkPosition) {
        return this.position == checkPosition;
    }
}
