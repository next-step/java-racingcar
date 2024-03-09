package racingcar.step3.print;

import racingcar.step3.Car;

import java.util.List;

public class DashVisualizePrintStrategy implements PrintStrategy {

    private final String DASH = "-";

    @Override
    public void printRoundResult(List<Car> cars) {
        cars.stream()
                .map(Car::getCurrentLocation)
                .forEach(location -> {
                    System.out.println(DASH.repeat(location));
                });
    }
}
