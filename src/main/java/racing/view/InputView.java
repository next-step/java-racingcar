package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_HOW_MANY_ROUND = "시도할 회수는 몇 회 인가요?";
    private static final String QUESTION_WHAT_IS_PALYER_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String COMMA = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputGameCount() {
        System.out.println(QUESTION_HOW_MANY_ROUND);
        return SCANNER.nextInt();
    }

    public static String[] inputPalyersName() {
        System.out.println(QUESTION_WHAT_IS_PALYER_NAME);
        return SCANNER.nextLine().split(COMMA);
    }
}
