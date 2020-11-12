package step03;

import step03.view.ResultView;
import validator.NumberValidator;

public class Race {
    private final int numberOfMoves;
    private final Cars cars;

    private Race(int numberOfMoves, Cars cars) {
        this.numberOfMoves = numberOfMoves;
        this.cars = cars;
    }

    public static Race of(int numberOfMoves, Cars cars) {
        validateNumberOfMoves(numberOfMoves);
        return new Race(numberOfMoves, cars);
    }

    private static void validateNumberOfMoves(int numberOfMoves) {
        NumberValidator.validatePositiveInteger(numberOfMoves);
    }

    public void operate(ResultView view) {
        view.print(cars.getCars());

        for (int i = 0; i < numberOfMoves; i++) {
            cars.move();
            view.print(cars.getCars());
        }

    }

}
