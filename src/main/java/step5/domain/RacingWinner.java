package step5.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {
    private static final String JOIN_DELIMITER = ",";
    private List<Car> winners;

    public RacingWinner(List<Car> cars) {
        this.winners = getWinners(cars, getMaxPosition(cars));
    }


    private int getMaxPosition(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<Car> getWinners(final List<Car> cars, final int winnerPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    public String getWinners() {
        return this.winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(JOIN_DELIMITER));
    }

}
