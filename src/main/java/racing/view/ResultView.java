package racing.view;

import racing.model.Car;

import java.util.stream.IntStream;

public class ResultView {
    private final String RESULT_MESSAGE = "실행결과";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCarsLocation(Car[] cars) {
        for (Car car : cars) {
            IntStream.rangeClosed(0, car.currentLocation())
                    .forEach(x -> System.out.print("-"));
            System.out.println();
        }
        System.out.println();
    }
}
