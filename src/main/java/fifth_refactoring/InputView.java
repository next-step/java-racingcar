package fifth_refactoring;

import java.util.Scanner;

public class InputView {
    private static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요";
    public static final String CAR_NAME_SPLIT_SIGN = ",";
    public static final String CAR_NAME_SPLIT_NAME = "쉼표";
    private static final String ASK_CAR_SPLIT_OPTION = "(이름은 " + CAR_NAME_SPLIT_NAME + "("
            + CAR_NAME_SPLIT_SIGN + ")를 기준으로 구분).";
    private static final String ASK_TRY_NUMBER = "시도할 회수는 몇 회 인가요?";
    private static Scanner scanner;
    private static CheckValidation checkValidation = new CheckValidation();

    public String askCarName() {
        System.out.println(ASK_CAR_NAME + ASK_CAR_SPLIT_OPTION);
        String carName = inputCarName();
        if (!checkValidation.validateCarName(carName)) {
            return "";
        }

        return carName;
    }

    public String inputCarName() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int askTryNumber() {
        System.out.println(ASK_TRY_NUMBER);
        int tryNumber = inputTryNumber();
        if (!checkValidation.validateTryNumber(tryNumber)) {
            return 0;
        }

        return tryNumber;
    }

    public int inputTryNumber() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
