package racingcar.step3.print;

import racingcar.step3.Car;

import java.util.List;

public class DashVisualizePrintStrategy implements PrintStrategy {

    private final String DASH = "-";

    @Override
    public void printRoundResult(List<Integer> carsCurrentLocation) {
        carsCurrentLocation.forEach(
                location -> System.out.println(DASH.repeat(location))
        );
    }
}
