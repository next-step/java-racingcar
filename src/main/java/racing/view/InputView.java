package racing.view;

import java.util.Scanner;

public class InputView {

    public static final String HOW_MANY_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String HOW_MANY_TRY = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarCount() {
        System.out.println(HOW_MANY_CARS);
        return scanner.next();
    }

    public static int inputTryCount() {
        System.out.println(HOW_MANY_TRY);
        return scanner.nextInt();
    }

}
