package racing.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String QUESTION_HOW_MANY_ROUND = "시도할 회수는 몇 회 인가요?";
    private static final String QUESTION_WHAT_IS_PALYER_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_LONG_NAME_VALIDATION = "자동차 이름은 5자를 초과 할 수 없습니다.";
    private static final String COMMA = ",";

    public static int inputGameCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_HOW_MANY_ROUND);
        return scanner.nextInt();
    }

    public static String[] inputPalyersName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_WHAT_IS_PALYER_NAME);
        String[] names = scanner.nextLine().split(COMMA);
        if (checkNameLength(names)) {
            System.out.println(INPUT_LONG_NAME_VALIDATION);
            throw new IllegalArgumentException(INPUT_LONG_NAME_VALIDATION);
        }
        return names;
    }

    private static boolean checkNameLength(String[] names) {
        return Arrays.stream(names)
                .anyMatch(name -> name.length() > 5);
    }
}
