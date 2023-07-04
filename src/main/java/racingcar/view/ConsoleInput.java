package racingcar.view;

import java.util.Scanner;

public class ConsoleInput {
    private static final String NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static final String COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final Scanner sc = new Scanner(System.in);

    public static String readNames() {
        System.out.println(NAMES_MESSAGE);
        return sc.nextLine();
    }

    public static int readCount() {
        System.out.println(COUNT_MESSAGE);
        return sc.nextInt();
    }
}
