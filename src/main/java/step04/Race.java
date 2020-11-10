package step04;

import validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Race {
    private final int numberOfMoves;
    private final Cars cars;
    private ArrayList<List<Car>> raceSnapShop = new ArrayList<>();
    private static final String joinDelimiter = ", ";

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

    private static String getWinner(List<Car> cars) {
        int topPosition = cars.stream()
                .sorted((a, b) -> b.getPosition() - a.getPosition())
                .limit(1)
                .collect(toList())
                .get(0)
                .getPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == topPosition)
                .map(car -> car.name)
                .collect(joining(joinDelimiter));
    }

    public void run(ResultView resultView) {
        setSnapShot(cars.clonedCars());

        for(int i = 0; i < numberOfMoves; i++) {
            cars.move();
            setSnapShot(cars.clonedCars());
        }

        resultView.printRace(raceSnapShop);
        String winners = getWinner(cars.cars);
        resultView.printWinner(winners);

    }

}
