package racing.domain;

public class Car {
    private final static int MIN_MOVE_NUM = 4;
    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
