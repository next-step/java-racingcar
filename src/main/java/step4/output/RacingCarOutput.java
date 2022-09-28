package step4.output;

import step4.Car;

import java.util.List;

public class RacingCarOutput {

    private static final String CAR_POSITION_INDEX = "-";

    public static void printCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void printTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public static void printRacingResult(List<Car> cars) {

        for (int i = 0; i < cars.size(); i++) {
            System.out.println(CAR_POSITION_INDEX.repeat(cars.get(i).getLocation()));
        }
        printDividingLine();
    }

    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printDividingLine() {
        System.out.println();
    }
}
