package racingcar;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> cars) {
        winners = pickWinnerOfRace(cars);
    }

    public List<Car> getWinners() {
        return winners;
    }

    private List<Car> pickWinnerOfRace(List<Car> cars) {
        final int maxCarPosition = getMaxCarPositionOfLastRound(cars);
        return pickCarsOnGivenPosition(cars, maxCarPosition);
    }

    private List<Car> pickCarsOnGivenPosition(List<Car> cars, int position) {
        return cars.stream().filter(car -> car.getCarPosition() == position).collect(Collectors.toList());
    }
    private int getMaxCarPositionOfLastRound(List<Car> cars) {
        return Objects.requireNonNull(cars.stream().max(Comparator.comparingInt(Car::getCarPosition)).orElse(null)).getCarPosition();
    }

}
