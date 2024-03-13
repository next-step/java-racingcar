package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_HOW_MANY_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_HOW_MANY_ROUND = "시도할 회수는 몇 회 인가요?";
    private static final String QUESTION_WHAT_IS_PALYER_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static int inputCarCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_HOW_MANY_CAR);
        return scanner.nextInt();
    }

    public static int inputGameCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_HOW_MANY_ROUND);
        return scanner.nextInt();
    }

    public static String[] inputPalyersName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_WHAT_IS_PALYER_NAME);
        String[] names = scanner.nextLine().split(",");
        return names;
    }
}
