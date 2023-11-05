package racingcar.model;

public class Car {
    int position;

    public Car() {
        this.position = 1;
    }

    public void moveCar() {
        if (tryToMove()) position++;
    }

    public void printPosition() {
        String currentPosition = "-".repeat(position);
        System.out.println(currentPosition);
    }

    private boolean tryToMove() {
        int success = 4;
        int range = 10;
        return Math.floor(Math.random() * range) >= success;
    }
}