package step4;

import java.util.List;

public class ResultView {

    private static int playTryTimes = 0;

    public static void viewResult(List<Car> cars) {

        System.out.println(++playTryTimes + " th Try.. ");
        for (Car car : cars) {
            printCurrentLocation(car);
        }

    }

    private static void printCurrentLocation(Car car) {
        System.out.println(car.getCarsName() + "\t\t : " + new String(new char[car.getLocation()]).replace("\0", "-"));
    }


}
