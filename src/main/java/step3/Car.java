package step3;

public class Car {
    private String name;
    private int position;
    private final static int ZERO = 0;

    public Car(String name) {
        this.name = name;
        this.position = ZERO;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

