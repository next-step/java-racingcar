package CarRacingGame;

public class CarRacingGame {
    static CarRacingGameUtils cars = new CarRacingGameUtils();

    public static void main(String[] args) {

        int numberOfCars = InputView.inputNumberOfCars();
        int numberOfAttempts = InputView.inputNumberOfAttempts();

        cars.initialCarSettings(numberOfCars);
        cars.printMovingCars(numberOfAttempts);
    }
}

