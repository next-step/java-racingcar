package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingResult {
    private static final String COMMA_SEPARATOR = ",";

    private List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinners() {
        int maxPosition = maxPosition();
        return getWinners(maxPosition);
    }

    private int maxPosition() {
        int maxPosition = 0;
        for (Car car: cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<Car> getWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car: cars) {
            if (car.isMaxPosition(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public String createDisplayWinnerNames() {
        List<Car> winners = findWinners();
        return joinComma(getWinnerNames(winners));
    }

    private static List<String> getWinnerNames(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car: winners) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }

    private static String joinComma(List<String> winnerNames) {
        return String.join(COMMA_SEPARATOR, winnerNames);
    }
}
