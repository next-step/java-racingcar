package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {

    public static void showResult(int times, List<Car> carList) {
        if (times == 0) {
            System.out.println("\n실행 결과");
        }

        for (Car car : carList) {
            System.out.println(printLocation(car.getLocation()));
        }

        System.out.println();
    }

    public static String printLocation(int location) {
        String locationMark = "-";
        while (location > 1) {
            locationMark += "-";
            location--;
        }
        return locationMark;
    }

}
