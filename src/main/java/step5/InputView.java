package step5;

import java.util.Scanner;

public class InputView {
    private static final String ASK_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_INPUT_TRIES = "시도할 회수는 몇 회 인가요?";

    public static String[] inputCarNames() {
        System.out.println(ASK_INPUT_CAR_NAMES);
        Scanner sc = new Scanner(System.in);
        return sc.next().split(",");
    }

    public static int inputTries() {
        System.out.println(ASK_INPUT_TRIES);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
