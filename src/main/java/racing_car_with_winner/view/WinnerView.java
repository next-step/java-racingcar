package racing_car_with_winner.view;

import java.util.List;
import java.util.stream.Collectors;

import racing_car_with_winner.model.car.Car;
import racing_car_with_winner.model.car.CarName;

public class WinnerView {
    private static final String SHOW_WINNER_TEMPLATE = "\n%s가 최종 우승했습니다.";
    private final String message;

    public WinnerView(List<Car> winners) {
        this.message = String.format(SHOW_WINNER_TEMPLATE, getWinnerCarName(winners));
    }

    public String getMessage() {
        return message;
    }

    private String getWinnerCarName(List<Car> winners) {
        return winners.stream()
                      .map(Car::getCarName)
                      .map(CarName::getValue)
                      .collect(Collectors.joining(","));
    }
}
