package racingcar.winner.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars moveCars(MovableStrategy movableStrategy) {
        List<Car> movedCars = cars.stream()
                                  .map(car -> car.tryMove(movableStrategy))
                                  .collect(Collectors.toList());

        return new Cars(movedCars);
    }

    public List<Car> findWinner() {
        List<Car> sortedCars = getArrangedCars();
        
        Car winner = sortedCars.get(0);

        List<Car> winners = new ArrayList<>();
        winners.add(winner);
        winners.addAll(getCoWinner(winner, sortedCars.subList(1, sortedCars.size()-1)));

        return winners;
    }

    private List<Car> getArrangedCars() {
        List<Car> sortedCars = new ArrayList<>(this.cars);

        Collections.copy(sortedCars, this.cars);

        sortedCars.sort(Comparator.reverseOrder());

        return sortedCars;
    }

    private List<Car> getCoWinner(Car winner, List<Car> otherCars) {
        return otherCars.stream()
                        .filter(winner::isSameResult)
                        .collect(Collectors.toList());
    }

}
