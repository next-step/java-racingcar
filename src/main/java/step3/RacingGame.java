package step3;

import step3.car.Cars;

public class RacingGame {

    private final int carNumber;
    private final int moveNumber;
    private final Cars cars;

    private RacingGame(int carNumber, int moveNumber) {
        this.carNumber = carNumber;
        this.moveNumber = moveNumber;
        this.cars = Cars.of(carNumber);
    }

    public static RacingGame of(int carNumber, int moveNumber) {
        return new RacingGame(carNumber, moveNumber);
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void play() {
        for (int i = 0; i < moveNumber; i++) {
            cars.play();
        }
    }

    public Cars getCars() {
        return cars;
    }
}
