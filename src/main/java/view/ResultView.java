package view;

import core.Car;

import java.util.List;
import java.util.stream.Stream;

public class ResultView {

    public static void printOutputValue(Car car) {
        car.stream().forEach(System.out::print);
        System.out.println();
    }

}
