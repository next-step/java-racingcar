package racingcar.model;

public class Car {
    int position;

    private static final int RANGE = 10;
    private static final int SUCCESS = 4;

    public Car() {
        this.position = 1;
    }

    public void moveCar() {
        if (tryToMove(generateRandomNumber())) position++;
    }

    public void printPosition() {
        String currentPosition = "-".repeat(position);
        System.out.println(currentPosition);
    }

    private boolean tryToMove(int random) {
        return random >= SUCCESS;
    }

    private int generateRandomNumber() {
        return (int) (Math.floor(Math.random() * (Car.RANGE + 1)));
    }

}