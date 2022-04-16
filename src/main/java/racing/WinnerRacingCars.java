package racing;

import java.util.List;

public class WinnerRacingCars {
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String DELIMITER = ", ";

    private final List<String> cars;

    public WinnerRacingCars(List<String> cars) {
        this.cars = cars;
    }

    public String get() {
        return String.join(DELIMITER, cars);
    }

    @Override
    public String toString() {
        return get() + WINNER_MESSAGE;
    }
}
