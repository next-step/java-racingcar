package ui;

import racing.Report;

import java.util.stream.IntStream;

public class OutputView {
    public static void printChampion(Report report) {
        var champions = report.findChampions();
        System.out.println(String.join(", ", champions) + "가 최종 우승했습니다.");
    }

    public static void printPosition(Report report) {
        printPosition(report.getCars().size(), report);
        System.out.println();
    }

    private static void printPosition(Integer carCount, Report report) {
        IntStream.range(0, carCount)
                .forEach(index -> {
                    var car = report.findCarByIndex(index);
                    var printMessage = car.getName() + " : " + "-".repeat(car.getPosition());
                    System.out.println(printMessage);
                });
    }
}
