package racingcar;

import java.util.Scanner;

public class InputView {

    private static final String HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MANY_TIMES = "시도할 회수는 몇 회 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static int getCarCount() {
        InputQuestion.print(HOW_MANY_CARS);
        return scanner.nextInt();
    }

    public static int getTryCount() {
        InputQuestion.print(HOW_MANY_TIMES);
        return scanner.nextInt();
    }

}
