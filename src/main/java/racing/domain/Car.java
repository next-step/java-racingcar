package racing.domain;

public class Car {
    private int position;
    private String name;

    public Car(String name) {
        this.position = 0;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }
}
