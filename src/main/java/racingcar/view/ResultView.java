package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

import static racingcar.Constants.*;
import static racingcar.utils.StringUtils.repeat;

public class ResultView{
    public static void printStartResult() {
        System.out.println("\n"+SAY_VIEW_RESULT);
    }

    public static void printCars(List<Car> cars) {
        cars.forEach(ResultView::dashPosition);
    }

    public static void dashPosition(Car car) {
        System.out.println(repeat("-", car.getPosition()));
    }

    public static void printLine() {
        System.out.println("");
    }
}
