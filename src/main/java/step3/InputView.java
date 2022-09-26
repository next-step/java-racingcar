package step3;

import java.util.Scanner;

public class InputView {

    public static final String CAR_NUM_TEXT = "자동차 대수는 몇 대 인가요?";
    public static final String TRY_NUM_TEXT = "시도할 회수는 몇 회 인가요?";
    public static final Scanner scanner = new Scanner(System.in);


    public static int inputCarNum() {
        System.out.println(CAR_NUM_TEXT);
        return scanner.nextInt();
    }

    public static int inputTryNum() {
        System.out.println(TRY_NUM_TEXT);
        return scanner.nextInt();
    }
}
