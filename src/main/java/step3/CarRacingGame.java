package step3;

import java.io.IOException;

public class CarRacingGame {

    private final Car[] cars;
    private int numberOfTry;

    public CarRacingGame(int numberOfCar, int numberOfTry) {
        this.cars = new Car[numberOfCar];
        this.numberOfTry = numberOfTry;
    }

    public void start() throws IOException {

    }

    public static void main(String[] args) throws IOException {
        GameOutput.println("자동차는 몇 대인가요?\n");
        int numberOfCar = GameInput.readInt();
        GameOutput.println("몇 번 시도할 것인가요?\n");
        int numberOfTry = GameInput.readInt();

        CarRacingGame carRacingGame = new CarRacingGame(numberOfCar, numberOfTry);
        carRacingGame.start();
    }
}
