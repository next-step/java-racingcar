package step2;

import java.util.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        return numberOfCars;
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return tryCount;
    }
}
