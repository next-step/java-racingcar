package step4;

import java.util.List;

/*
 * ResultView
 * ver. 1.0
 * 2020.05.27
 * Copyright ...
 */
public class ResultView {

    private static int playTimes = 0;

    public static void viewResult(List<Car> cars) {

        System.out.println(++playTimes + " th Try.. ");
        for (Car car : cars) {
            printCurrentLocation(car);
        }

    }

    private static void printCurrentLocation(Car car) {
        System.out.println(car.getCarName() + "\t\t : "
                + new String(new char[car.getLocation()]).replace("\0", "-"));
    }

    public static void printWinner(String winners) {
        System.out.println(winners + "\t\t is(are) Winner(s). ");
    }


}
