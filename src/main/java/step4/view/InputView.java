package step4.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String QUESTION_CAR = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_ROUND_COUNT = "시도할 회수는 몇 회 인가요?";

    public static String inputCarCount() {
        System.out.println(QUESTION_CAR);
        return scanner.nextLine();
    }

    public static int inputRoundCount() {
        System.out.println(QUESTION_ROUND_COUNT);
        return scanner.nextInt();
    }
}
