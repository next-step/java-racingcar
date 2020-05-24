package study.step5.view;

import java.util.Scanner;

public class InputView {
    private final static String CAR_INPUT_QUESTION ="경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String TRY_TIME_INPUT_QUESTION ="시도 회수는 몇 회 인가요?";
    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputCarNames(){
        System.out.println(CAR_INPUT_QUESTION);
        return scanner.nextLine();
    }

    public static int inputTryTime() {
        System.out.println(TRY_TIME_INPUT_QUESTION);
        return scanner.nextInt();
    }
}
