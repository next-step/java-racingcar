package step5.view;

import step5.domain.Cars;

/*
 * ResultView
 * ver. 1.0
 * 2020.05.27
 * Copyright ...
 */
public class ResultView {

    private static int playTimes = 0;

    public static void viewResult(Cars cars) {

        System.out.println(++playTimes + " th Try.. ");
        printCurrentLocation(cars);

    }

    public static void printCurrentLocation(Cars cars) {

        cars.getCarsList().forEach(car -> {
            System.out.println(car.getCarName() + "\t\t : "
                    + new String(new char[car.getLocation()]).replace("\0", "-"));

        });

    }


    public static void printWinner(String winners) {
        System.out.println(winners + "\t\t is(are) Winner(s). ");
    }

}
