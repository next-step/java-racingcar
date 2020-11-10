package step04;

import validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final int numberOfMoves;
    private final Cars cars;
    private ArrayList<List<Car>> raceSnapShop = new ArrayList<>();

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

    private void setSnapShot(List<Car> cars) {
        raceSnapShop.add(cars);
    }

    public void run(ResultView resultView) {
        setSnapShot(cars.clonedCars());

        for(int i = 0; i < numberOfMoves; i++) {
            cars.move();
            setSnapShot(cars.clonedCars());
        }

        resultView.printRace(raceSnapShop);
        resultView.printWinner(cars.cars);

    }

}
