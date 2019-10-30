package step3;

public class Car {
    private final static int ZERO = 0;
    private String name;
    private int position;

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

    public void updatePosition(int movePosition) {
        this.position = position + movePosition;
    }
}

