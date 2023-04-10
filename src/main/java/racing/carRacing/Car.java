package racing.carRacing;

public class Car {
    private int position;

    public Car() {
        position = 0;
    }

    public Car(int position) {
        this.position = position;
    }

    public void run(MovementStrategy strategy) {
        if (strategy.movement()) {
            position++;
        }
    }

    public int getCurrentPosition() {
        return position;
    }
}
