package step3.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public InputView() {
    }

    public static int getCarCount() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return inputCarCount();
    }

    public static int getTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return inputTryCount();
    }

    private static int inputCarCount(){
        return scanner.nextInt();
    }

    private static int inputTryCount(){
        return scanner.nextInt();
    }
}
