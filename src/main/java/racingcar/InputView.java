package racingcar;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static void printCarInputGuideMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
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

    public static String[] getCarNames() {
        InputView.printCarInputGuideMessage();
        String carNames = scanner.nextLine();
        String[] carNamesArray = carNames.split(",");
        Validator.validateCarAmount(carNamesArray.length);
        return carNamesArray;
    }
}
