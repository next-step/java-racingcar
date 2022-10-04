package racingcar;

import java.util.List;

public class ResultView {
    public static void printCars(List<Car> cars) {
        cars.forEach(ResultView::printBar);
        System.out.println();
    }

    private static void printBar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("|");
        }
        System.out.println();
    }


}
