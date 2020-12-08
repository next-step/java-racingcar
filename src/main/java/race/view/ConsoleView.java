package race.view;

import race.domain.RacingCars;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ConsoleView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String MOVEMENT_SYMBOL = "-";

    public static int inputNumOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int inputNumOfTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static void showResult(RacingCars cars) {
        System.out.println("실행 결과");
        for (Integer distance : cars.getDistanceOfCars()) {
            IntStream.range(0, distance).forEach(i -> System.out.print(MOVEMENT_SYMBOL));
            System.out.println();
        }
    }
}
