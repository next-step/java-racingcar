package racingcar;

import java.util.Random;

public class RacingController {
    private final static int BOUND = 10;

    public static void start(Rule rule) {
        int[] cars = readyCars(rule.getCountOfCar());

        System.out.println("실행 결과");

        for (int attempt = 0; attempt < rule.getMaxAttempts(); attempt++) {
            turnAroundCircuit(cars);
            int round = attempt;
            System.out.println(++round +"회차 종료");
        }
    }

    private static int[] readyCars(int countOfCar) {
        return new int[countOfCar];
    }

    private static void turnAroundCircuit(int[] cars) {
        for (int carIndex = 0; carIndex < cars.length; carIndex++) {
            cars[carIndex] += new RacingCar().move(new Random().nextInt(BOUND));
            Printer.print(cars[carIndex]);
        }
    }
}
