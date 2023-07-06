package racing.domain;

public class Car {
    private static final int INITIAL_POSITION = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private int position;
    private String name;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;

        validateName();
    }

    private void validateName() {
        if (this.name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException();
        }
    }

    public void goForward(boolean trigger) {
        if (trigger) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
