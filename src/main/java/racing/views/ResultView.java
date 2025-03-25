package racing.views;

import racing.domain.Car;
import racing.data.Messages;
import racing.domain.Cars;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResult(Car car) {
        println("-".repeat(car.getPosition()));
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void printResultWithName(Car car) {
        println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
    }
    public static void printResultWithName(Cars cars) {
        for(Car car : cars.getCars()){
            printResultWithName(car);
        }
        println("");
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

    public static void printWinner(List<Car> cars) {
        println(cars.stream().map(Car::getCarName).collect(Collectors.joining(", ")) + Messages.RACE_WINNER);
    }

    public static void showResult() {
        println(Messages.RACE_RESULT);
    }
}
