package racingcar;

import java.util.Formatter;
import java.util.List;

public class ResultView {

    private static final String Bar = "-";

    public static void printCars(List<Car> cars) {
        cars.forEach(ResultView::printBar);
        System.out.println();
    }

    private static void printBar(Car car) {
        System.out.print(String.format("%s : ", car.getName()));
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(Bar);
        }
        System.out.println();
    }


}
