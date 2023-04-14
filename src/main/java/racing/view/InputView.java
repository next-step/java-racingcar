package racing.view;

import java.util.Scanner;

public class InputView {

    public static final String HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    public static final String HOW_MANY_TRY = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        System.out.println(HOW_MANY_CARS);
        return scanner.nextInt();
    }

    public static int inputTryCount() {
        System.out.println(HOW_MANY_TRY);
        return scanner.nextInt();
    }

}
