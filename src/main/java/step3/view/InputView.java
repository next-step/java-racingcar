package step3.view;

import java.util.Scanner;

import static step3.util.NumberValidator.validateTryNumber;

public class InputView {
    private static final String inputCarNamesMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static final String inputTryNumberMessage = "시도할 회수는 몇 회 인가요?";


    public static String inputCarNames(Scanner scanner) {
        System.out.println(inputCarNamesMessage);
        return scanner.nextLine();
    }

    public static int inputTryNumbers(Scanner scanner) {
        System.out.println(inputTryNumberMessage);
        return validateTryNumber(scanner.nextInt());
    }
}
