package RacingCar;

public class Car {
    private final int id;
    private int currentPosition;

    public Car(int id) {
        this.id = id;
        this.currentPosition = 0;
    }

    public int getId() { return id; }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
