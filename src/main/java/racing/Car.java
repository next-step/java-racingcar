package racing;

public class Car {
    private int position;
    private String name;

    public Car(String name) {
        this.name = name;
        this.position = 1;
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
