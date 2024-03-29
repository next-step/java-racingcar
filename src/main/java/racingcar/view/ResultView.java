package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + markLocation(car.getLocation()));
        }
        System.out.println();
    }

    private static String markLocation(int location) {
        String mark = "-";
        return mark.repeat(location);
    }

    public static void printGameResult(List<String> cars){
        System.out.println(cars.toString() + "가 최종 우승했습니다.");
    }
}
