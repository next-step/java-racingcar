package carRacingGame;

public class CarRacingGame {
    static CarRacingGameUtils cars = new CarRacingGameUtils();

    public static void main(String[] args) {
        String[] nameOfCars = InputView.inputNameOfCars();
        int numberOfAttempts = InputView.inputNumberOfAttempts();

        cars.setupCars(nameOfCars);
        cars.displayRaceProgress(numberOfAttempts);
        cars.printWinnerName();
    }
}

