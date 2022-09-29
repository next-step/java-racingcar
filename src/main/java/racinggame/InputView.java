package racinggame;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static int inputNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return inputPositiveNumber();
    }

    public static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return inputPositiveNumber();
    }

    private static int inputPositiveNumber() {
        int num = SCANNER.nextInt();
        if (num <= 0) {
            throw new RuntimeException("0 또는 음수는 전달할 수 없습니다.");
        }
        return num;
    }

}
