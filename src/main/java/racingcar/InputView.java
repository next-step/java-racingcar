package racingcar;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static void printCarInputGuideMessage() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void printTryInputGuideMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static int getTryAmount() {
        InputView.printTryInputGuideMessage();
        int tryAmount = scanner.nextInt();
        Validator.validateTryAmount(tryAmount);
        return tryAmount;
    }

    public static int getCarAmount() {
        InputView.printCarInputGuideMessage();
        int carAmount = scanner.nextInt();
        Validator.validateCarAmount(carAmount);
        return carAmount;
    }
}
