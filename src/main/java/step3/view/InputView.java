package step3.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";

    public InputView() {
    }

    public static int getCarCount() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return inputCarCount();
    }

    private static int inputCarCount(){
        return scanner.nextInt();
    }
}
