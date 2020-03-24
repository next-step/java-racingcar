package fifth_refactoring.view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요";
    public static final String CAR_NAME_SPLIT_SIGN = ",";
    public static final String CAR_NAME_SPLIT_NAME = "쉼표";
    private static final String ASK_CAR_SPLIT_OPTION = "(이름은 " + CAR_NAME_SPLIT_NAME + "("
            + CAR_NAME_SPLIT_SIGN + ")를 기준으로 구분).";
    private static final String ASK_TRY_NUMBER = "시도할 회수는 몇 회 인가요?";
    private static Scanner scanner = new Scanner(System.in);
    private static CheckValidation checkValidation = new CheckValidation();

    public static String askCarName() {
        System.out.println(ASK_CAR_NAME + ASK_CAR_SPLIT_OPTION);
        String carName = inputCarName();
        if (!checkValidation.validateCarName(carName)) {
            return "";
        }

        return carName;
    }

    public static String inputCarName() {
        return scanner.nextLine();
    }

    public static int askTryNumber() {
        System.out.println(ASK_TRY_NUMBER);
        int tryNumber = inputTryNumber();
        if (!checkValidation.validateTryNumber(tryNumber)) {
            return 0;
        }

        return tryNumber;
    }

    public static int inputTryNumber() {
        return scanner.nextInt();
    }
}
