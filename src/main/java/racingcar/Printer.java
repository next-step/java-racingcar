package racingcar;

import java.util.List;

public class Printer {
    public static void println(String printable) {
        System.out.println(printable);
    }

    private static void print(String printable) {
        System.out.print(printable);
    }

    public static void print(RacingCars cars) {
        for (RacingCar car : cars.getCars()) {
            print(car.getName() + " : ");
            print(car.getMovement());
        }
    }

    private static void print(int count) {
        for (int print = 0; print < count; print++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void award(List<String> winners) {
        println("이번 대회 승자 : " + decorateWinners(winners));
    }

    private static String decorateWinners(List<String> winners) {
        StringBuilder decoratedWinners = new StringBuilder();
        for (String winner : winners) {
            decoratedWinners.append(winner).append(" ");
        }
        return decoratedWinners.toString();
    }
}
