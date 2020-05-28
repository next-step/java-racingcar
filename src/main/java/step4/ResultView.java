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

    public static void viewResult(Cars cars) {

        System.out.println(++playTimes + " th Try.. ");

        cars.printCurrentLocation();
    }



    public static void printWinner(String winners) {
        System.out.println(winners + "\t\t is(are) Winner(s). ");
    }


}
