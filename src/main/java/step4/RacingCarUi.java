package step4;

import java.util.List;
import java.util.Scanner;

public class RacingCarUi {
    private static final Scanner scanner = new Scanner(System.in);

    public static String receiveRacerInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public static int receiveMoveInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public static void resultPrint(List<Car> cars) {
        cars.stream()
                .map(Car::toString)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void close() {
        scanner.close();
    }
}
