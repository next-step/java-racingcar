package step5.view;

import java.util.Scanner;

public class InputView {
    public static final String FIRST_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분";
    public static final String SECOND_QUESTION = "시도할 회수는 몇 회 인가요?";
    public static final String WRONG_ARGUMENT = "잘못된 인자입니다.";
    public static final String QUESTION_NUMBER_ONE = "1";
    public static final String QUESTION_NUMBER_TWO = "2";
    private static final Scanner scanner = new Scanner(System.in);
    private int trialCounts;
    private String[] namesOfCars;

    public InputView() {
        this.trialCounts = 0;
        this.namesOfCars = new String[]{"",};
    }

    public static String askQuestion(String value) {
        if (value.equals(QUESTION_NUMBER_ONE)) {
            return FIRST_QUESTION;
        }
        if (value.equals(QUESTION_NUMBER_TWO)) {
            return SECOND_QUESTION;
        }
        return WRONG_ARGUMENT;
    }

    public void runInputView() {
        System.out.println(askQuestion(QUESTION_NUMBER_ONE));
        namesOfCars = scanner.nextLine().split(",");
        System.out.println(askQuestion(QUESTION_NUMBER_TWO));
        trialCounts = scanner.nextInt();
    }

    public String[] getNamesOfCars() {
        return namesOfCars;
    }

    public int getTrialCounts() {
        return trialCounts;
    }
}
