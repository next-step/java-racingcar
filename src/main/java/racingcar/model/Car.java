package racingcar.model;

public class Car {
    int position;

    private static final int RANGE = 10;
    private static final int SUCCESS = 4;

    public Car() {
        this.position = 1;
    }

    public void moveCar(boolean move) {
        if (move) position++;
    }

    public String getDistance() {
        return "-".repeat(position);
    }

    public boolean tryToMove(int random) {
        return random >= SUCCESS;
    }

    public int generateRandomNumber() {
        return (int) (Math.floor(Math.random() * (Car.RANGE + 1)));
    }

}