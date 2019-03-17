package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.*;

public class RacingResult {

    static final String WINNER_SEPARATOR = ",";

    private List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        int maximumPosition = getMaximumPosition();

        return cars.stream()
                .filter(c -> c.hasMaximumPosition(maximumPosition))
                .collect(toList());
    }

    int getMaximumPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Car.INITIAL_POSITION);
    }

    public String getDisplayableWinnerNames() {
        return getJoinedWinnerNames(getWinnerNames(getWinners()));
    }

    public static List<String> getWinnerNames(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();

        for(Car curCar : winners) {
            winnerNames.add(curCar.getName());
        }

        return winnerNames;
    }

    public static String getJoinedWinnerNames(List<String> winnerNames) {
        return String.join(WINNER_SEPARATOR, winnerNames);
    }
}
