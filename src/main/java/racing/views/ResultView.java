package racing.views;

import racing.Car;
import racing.data.Messages;

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

    public static void printWinner(List<Car> cars) {
        println(cars.stream().map(Car::getCarName).collect(Collectors.joining(", ")) + Messages.RACE_WINNER);
    }

    public static void showResult() {
        println(Messages.RACE_RESULT);
    }
}
