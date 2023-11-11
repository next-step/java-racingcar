package racing.domain;

public class Car {
    private int distance;
    private String name;
    private static final int CONDITION_FOR_MOVE = 4;

    public Car(String name) {
        this.distance = 0;
        this.name = name;
    }

    public int getDistance() {
        return this.distance;
    }

    public String name() {
        return name;
    }

    public void moveCar() {
        this.distance++;
    }

    public void validateForMove(int randomValue) {
        if (isMovable(randomValue)) {
            this.moveCar();
        }
    }

    private static boolean isMovable(int randomValue) {
        return randomValue >= CONDITION_FOR_MOVE;
    }
}
