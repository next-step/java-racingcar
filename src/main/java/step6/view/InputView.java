package step6.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final Scanner sc = new Scanner(System.in);

    public static String requireCarName() {
        System.out.println(CAR_NAME);
        return sc.nextLine();
    }
}
