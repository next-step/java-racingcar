package racing.view;

import racing.model.Car;

import java.util.Collections;
import java.util.List;

public class CliOutputView {

    private static final String CAR_MOVING_BAR = "-";

    private CliOutputView() {}

    public static void printCars(List<Car> cars) {
        cars.forEach(car -> {
            String movingBar = String.join("",
                    Collections.nCopies(car.getMovingDistance(), CAR_MOVING_BAR));
            System.out.println(movingBar);
        });
        System.out.println();
    }

    public static void printStartSentence() {
        System.out.println("실행 결과");
    }
}
