import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResult(Car car) {
        println("-".repeat(car.getDistance()));
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void printResultWithName(Car car) {
        println(car.getCarName() + " : " + "-".repeat(car.getDistance()));
    }

    public static void printTypeError() {
        println(Messages.ERROR_VALID_TYPE);
    }

    public static void askCarNames() {
        println(Messages.ASK_CAR_NAMES);
    }

    public static void askCarCounts() {
        println(Messages.ASK_CAR_COUNT);
    }

    public static void askTryTimes() {
        println(Messages.ASK_TRY_TIMES);
    }

    public static void printResult() {
        println(Messages.RACE_RESULT);
    }

    public static void printWinner(List<Car> cars){
        println(getWinner(cars));
    }

    public static String getWinner(List<Car> cars) {

        int maxDistance = cars.stream().max(Comparator.comparing(Car::getDistance)).get().getDistance();

        List<Car> maxCars = cars.stream().collect(Collectors.groupingBy(Car::getDistance)).get(maxDistance);

        return maxCars.stream().map(Car::getCarName).collect(Collectors.joining(","));
    }


}
