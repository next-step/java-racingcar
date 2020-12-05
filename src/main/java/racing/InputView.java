package racing;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_TIMES = "시도할 회수는 몇 회 인가요?";

    public static int numberOfCars() {
        System.out.println(NUMBER_OF_CARS);
        return SCANNER.nextInt();
    }

    public static int tryTimes() {
        System.out.println(TRY_TIMES);
        return SCANNER.nextInt();
    }
}
