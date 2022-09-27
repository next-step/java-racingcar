package racingGame.view;

import racingGame.Car;
import racingGame.Cars;

import java.util.List;

public class ResultView {
    private static final String TIRE_MARK = "-";

    public static void printRacingResult(Cars cars) {
        printTitle();
        final StringBuilder stringBuilder = new StringBuilder();
        cars.getCars().forEach(car -> System.out.println(car.createTrace(TIRE_MARK)));
    }


    private static void printTitle() {
        System.out.println("살행결과");
    }


}
