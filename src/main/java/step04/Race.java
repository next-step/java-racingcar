package step04;

import validator.NumberValidator;

public class Race {
    private final int numberOfMoves;
    private final Cars cars;

    private Race(int numberOfMoves, Cars cars) {
        this.numberOfMoves = numberOfMoves;
        validateNumberOfMoves();
        this.cars = cars;
    }

    public static Race of (int numberOfMoves, Cars cars) {
        return new Race(numberOfMoves, cars);
    }

    private void validateNumberOfMoves() {
        NumberValidator.validatePositiveNumber(this.numberOfMoves);
    }

    public void operate(ResultView resultView) {
        resultView.setSnapShot(cars.clonedCars());

        for(int i = 0; i < numberOfMoves; i++) {
            cars.move();
            resultView.setSnapShot(cars.clonedCars());
        }

        resultView.printRace();
        resultView.printWinner();
    }

}
