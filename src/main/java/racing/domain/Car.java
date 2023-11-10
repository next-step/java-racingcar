package racing.domain;

public class Car {
    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public void moveCar() {
        this.distance++;
    }

    public void validateForMove(int randomValue) {
        if (randomValue >= 4) {
            this.moveCar();
        }
    }
}
