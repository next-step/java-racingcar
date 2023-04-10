package racing.carRacing;

public class Car {
    private int position;
    private String name;

    public Car(String name) {
        position = 0;
        this.name = name;
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

    public String getCurrentCar() {
        return name;
    }
}
