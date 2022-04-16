package racing;

import java.util.ArrayList;
import java.util.List;

public class WinnerRacingCars {
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String DELIMITER = ", ";

    private final RacingCars cars;

    public WinnerRacingCars(RacingCars cars) {
        this.cars = cars;
    }

    public String getCars() {
        List<String> carList = new ArrayList<>();

        for (Car car : cars) {
            carList.add(car.getCarName());
        }

        return String.join(DELIMITER, carList);
    }

    @Override
    public String toString() {
        return getCars() + WINNER_MESSAGE;
    }
}
