package step3;

import java.util.List;

public class ResultView {

    private static int playTryTimes = 0;

    public static void viewResult(List<Car> cars) {

        System.out.println(playTryTimes++ + " th Try.. ");

        for (Car car : cars) {
            printCurrentLocation(car.getLocation());
        }

    }

    private static void printCurrentLocation(int location) {
        System.out.println(new String(new char[location]).replace("\0", "-"));
    }


}
