package study.step_4.ui;

import java.util.Scanner;

public class InputView {

    private static final int VALIDATION_NAME_CONDITION = 5;
    private static final String NAME_VALIDATION_MESSAGE = "이름은" + InputView.VALIDATION_NAME_CONDITION + "글자를 초과할 수 없습니다.";
    public static final String REGEX = ",";
    Scanner sc = new Scanner(System.in);

    public String[] welcomeMessage() {
        System.out.println(InfoMessage.CAR_COUNT_QUESTION.getMessage());
        return validateNameLength(getSplitCarName());
    }

    public String[] validateNameLength(String[] names) {
        for (String name : names) {
            NameLengthValidation(name);
        }
        return names;
    }

    private void NameLengthValidation(String name) {
        if (name.length() > InputView.VALIDATION_NAME_CONDITION) {
            throw new RuntimeException(NAME_VALIDATION_MESSAGE);
        }
    }

    private String[] getSplitCarName() {
        return sc.nextLine().split(REGEX);
    }

    public int askAttemptMessage() {
        System.out.println(InfoMessage.ATTEMPT_COUNT_QUESTION.getMessage());
        return getAnInt();
    }

    private int getAnInt() {
        return Integer.parseInt(sc.next());
    }
}
