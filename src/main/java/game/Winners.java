package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {

    private static StringBuffer winners;

    public static String findWinners(List<Car> cars) {
        winners = new StringBuffer();
        sortBiggest(cars);
        Car car = cars.get(0);
        for (Car target : cars) {
            toWinners(car, target);
        }
        return trimString();
    }

    private static String trimString(){
        return winners.substring(0,winners.length()-2);
    }

    private static void sortBiggest(List<Car> cars) {
        Collections.sort(cars);
    }

    private static void toWinners(Car car, Car target) {
        if (car.isSameLocation(target)) {
            winners.append(target.getName()+", ");
        }
    }
}
