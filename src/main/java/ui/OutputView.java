package ui;

import racing.GrandPrix;
import racing.Report;

import java.util.stream.IntStream;

public class OutputView {

    public static void printResult(GrandPrix grandPrix) {
        var report = grandPrix.report();
        printPosition(grandPrix.getCarCount(), report);
        System.out.println();
    }

    private static void printPosition(Integer carCount, Report report) {
        IntStream
                .range(0, carCount)
                .forEach(index -> {
                    var car = report.findCarByIndex(index);
                    var printMessage = car.getName() + " : " + "-".repeat(car.getPosition());
                    System.out.println(printMessage);
                });
    }
}
