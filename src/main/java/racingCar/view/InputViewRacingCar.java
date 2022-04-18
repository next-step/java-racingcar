package racingCar.view;

import java.util.Scanner;

public class InputViewRacingCar {

    private static final Scanner scanner = new Scanner(System.in);

    private InputViewRacingCar() {
    };

    public static String[] inputPlayCarNum() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");

        return splitCarNames(inputString());
    }

    private static String[] splitCarNames(String cars) {
        return cars.split(",");
    }

    public static int inputRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        return inputInt();
    }

    private static String inputString() {
        return scanner.nextLine();
    }

    private static int inputInt() {
        return scanner.nextInt();
    }
}
