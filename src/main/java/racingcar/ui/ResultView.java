package racingcar.ui;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    private static final String POSITION_DISPLAY_CHARACTER = "-";

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            printPosition(car);
        }
    }

    private static void printPosition(Car car) {
        StringBuilder builder = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(POSITION_DISPLAY_CHARACTER);
        }
        System.out.println(builder.toString());
    }

}
