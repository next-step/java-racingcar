package racing;

import java.util.stream.Collectors;

public class WinnerRacingCars {
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String DELIMITER = ", ";

    private final RacingCars cars;

    public WinnerRacingCars(RacingCars cars) {
        this.cars = cars;
    }

    public String getCars() {
        return cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(DELIMITER));
    }

    @Override
    public String toString() {
        return getCars() + WINNER_MESSAGE;
    }
}
