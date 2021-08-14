package racingcar;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(Race race) {
        winners = pickWinnerOfRace(race);
    }

    public List<Car> getWinners() {
        return winners;
    }

    private List<Car> pickWinnerOfRace(Race race) {
        List<Car> cars = getLastRoundCars(race);
        final int maxCarPosition = getMaxCarPositionOfLastRound(cars);
        return pickCarsOnGivenPosition(cars, maxCarPosition);
    }

    private List<Car> pickCarsOnGivenPosition(List<Car> cars, int position) {
        return cars.stream().filter(car -> car.getCarPosition() == position).collect(Collectors.toList());
    }
    private int getMaxCarPositionOfLastRound(List<Car> cars) {
        return Objects.requireNonNull(cars.stream().max(Comparator.comparingInt(Car::getCarPosition)).orElse(null)).getCarPosition();
    }

    private List<Car> getLastRoundCars(Race race) {
        List<List<Car>> carsInRounds = race.getCarsStatusForEachRound();
        return carsInRounds.get(carsInRounds.size()-1);
    }
}
