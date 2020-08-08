package domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Referee {
    private final List<Car> finishedCars;

    public Referee(List<Car> finishedCars) {
        this.finishedCars = finishedCars;
    }

    private List<Car> getWinnerCars() {
        List<Integer> carLengths = finishedCars.stream().map(Car::getLength).collect(Collectors.toList());

        return finishedCars.stream().filter(isCarWinner(carLengths)).collect(Collectors.toList());
    }

    private Predicate<Car> isCarWinner(List<Integer> carLengths) {
        return e -> e.getLength() == Collections.max(carLengths);
    }

    public String getWinnersCarNames() {
        List<Car> winnerCars = getWinnerCars();
        return winnerCars.stream().map(Car::getName).collect(Collectors.joining(","));
    }

}
