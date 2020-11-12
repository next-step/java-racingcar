package step5.view;

import step5.domain.Car;
import step5.domain.RacingWinner;

import java.util.List;
import java.util.Scanner;

public class RacingCarUi {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAME_COMMA = ",";

    public static String[] receiveRacerInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.next();
        return carNames.split(CAR_NAME_COMMA);

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

    public static void finalWinner(List<Car> cars) {
        RacingWinner racingWinner = new RacingWinner(cars);
        System.out.println(racingWinner.toString());
    }

    public static void close() {
        scanner.close();
    }
}
