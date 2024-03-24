package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + markLocation(car.getLocation()));
        }
        System.out.println();
    }

    public static String markLocation(int location) {
        String mark = "-";
        while (location > 0) {
            mark += "-";
            location--;
        }
        return mark;
    }
}
