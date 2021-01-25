package view;

import java.util.Scanner;

public class InputView {
    private static final String START_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NO_QUESTION = "시도할 횟수는 몇 회인가요?";

    public static String getCarNames() {
        System.out.println(START_QUESTION);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getTryNo() {
        System.out.println(TRY_NO_QUESTION);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
