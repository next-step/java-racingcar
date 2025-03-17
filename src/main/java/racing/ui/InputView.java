package racing.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAME_DELIMITER = ",";

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        return splitCarNames(inputString());
    }

    private static String[] splitCarNames(String carNames) {
        return carNames.split(CAR_NAME_DELIMITER);
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return inputNumber();
    }

    private static int inputNumber() {
        return scanner.nextInt();
    }

    private static String inputString() {
        return scanner.nextLine();
    }
}
