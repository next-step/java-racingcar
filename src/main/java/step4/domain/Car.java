package step4.domain;

public class Car {

    private static final int THRESHOLD = 4;
    private static final int MAX_NAME_SIZE = 5;

    private final String name;
    private int forwardCount = 0;

    public Car(String name) {
        this.validateName(name);
        this.name = name;
    }

    public void move(int randomNumber) {
        if (isImmovable(randomNumber)) {
            return;
        }
        this.forwardCount++;
    }

    public String getName() {
        return this.name;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }

    private boolean isImmovable(int number) {
        return number < THRESHOLD;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new RuntimeException();
        }
    }
}
