package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_LABS = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> askQuestionCarNames(){
        return Arrays.asList(getCarNamesInput());
    }

    public static int askQuestionLabs(){
        return getLabsInput();
    }

    private static String[] getCarNamesInput() {
        System.out.println(QUESTION_CAR_NAMES);

        String nameInput = scanner.next();
        String[] names = nameInput.split(",");
        for (String name : names) {
            validateNameSize(name);
        }
        return names;
    }

    private static void validateNameSize(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할수 없습니다. " + name + " 이름을 확인해주세요.");
        }
    }

    private static int getLabsInput() {
        System.out.println(QUESTION_LABS);

        int input = scanner.nextInt();
        if (input < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return input;
    }
}
