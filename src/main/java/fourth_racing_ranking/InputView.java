package fourth_racing_ranking;

import java.util.Scanner;

public class InputView {
    private static final String ASK_QUESTION_1 = "경주할 자동차 이름을 입력하세요";
    public static final String CAR_NAME_SPLIT_SIGN = ",";
    public static final String CAR_NAME_SPLIT_NAME = "쉼표";
    private static final String ASK_QUESTION1_OPTION = "(이름은 " + CAR_NAME_SPLIT_NAME + "("
            + CAR_NAME_SPLIT_SIGN + ")를 기준으로 구분).";
    private static final String ASK_QUESTION_2 = "시도할 회수는 몇 회 인가요?";
    private static Scanner scanner;
    private static ValidationCheck validationCheck = new ValidationCheck();

    public String askQuestion1() {
        System.out.println(ASK_QUESTION_1 + ASK_QUESTION1_OPTION);
        String carName = inputCarName();
        if (!validationCheck.valdationCarName(carName)) {
            return "";
        }

        return carName;
    }

    public String inputCarName() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int askQuestion2() {
        System.out.println(ASK_QUESTION_2);
        int tryNumber = inputTryNumber();
        if (!validationCheck.valdationTryNumber(tryNumber)) {
            return 0;
        }

        return tryNumber;
    }

    public int inputTryNumber() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
