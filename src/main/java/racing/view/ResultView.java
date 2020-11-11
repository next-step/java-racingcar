package racing.view;

import racing.model.Car;
import racing.model.RacingCars;

import java.util.stream.IntStream;

public class ResultView {
    private final String RESULT_MESSAGE = "실행결과";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingResult(RacingCars cars) {
        for (Car car : cars.getCandidates()) {
            System.out.print(car.getCarName()+" : ");
            IntStream.rangeClosed(0, car.currentLocation())
                    .forEach(x -> System.out.print("-"));
            System.out.println();
        }
        System.out.println();
    }
}
