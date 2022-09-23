package step3.output;

import step3.Car;

public class RacingCarOutput {

    public static void printCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void printTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public static void printRacingResult(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        printDividingLine();
    }

    public static void printResultStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printDividingLine() {
        System.out.println();
    }
}
