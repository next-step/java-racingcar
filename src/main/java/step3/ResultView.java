package step3;

import java.util.List;

public class ResultView {


    public static void viewResult(List<Car> cars) {
        for (Car car : cars) {
            printCurrentLocation(car.getLocation());
        }
    }

    private static void printCurrentLocation(int location) {
        System.out.println(new String(new char[location]).replace("\0", "-"));
    }


}
