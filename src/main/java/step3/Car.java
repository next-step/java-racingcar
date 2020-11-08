package step3;

public class Car {

    private int location;
    private final String name;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void move(int value) {
        if (value > bound || value < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANDOM_VALUE);
        }
        if (value > 4) {
            goForward();
        }
    }

    private void goForward() {
        location++;
    }

    public int getLocation() {
        return location;
    }

    public Record exportRecord() {
        return new Record(this.name, this.location);
    }

}
