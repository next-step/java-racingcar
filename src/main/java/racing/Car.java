package racing;

public class Car {
    private static final int INITIAL_POSITION = 1;
    private int position;
    private String name;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void goForward(boolean trigger) {
        if (trigger) this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
