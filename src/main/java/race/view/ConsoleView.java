package race.view;

import race.domain.Car;
import race.domain.RacingCars;
import race.domain.RacingWinners;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ConsoleView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String MOVEMENT_SYMBOL = "-";

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int inputNumOfTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static void showResult(RacingCars cars) {
        System.out.println("실행 결과");
        IntStream.range(0, cars.size()).forEach(index -> {
            Car car = cars.get(index);
            showName(car.getName());
            showDistance(car.getMovedDistance());
            System.out.println();
        });
    }

    private static void showName(String name) {
        System.out.print(name + " : ");
    }

    private static void showDistance(int distance) {
        IntStream.range(0, distance).forEach(i -> System.out.print(MOVEMENT_SYMBOL));
    }

    public static void showError(String message) {
        System.err.println(message);
    }

    public static void showWinners(RacingWinners winners) {
        System.out.println(winners);
    }
}
