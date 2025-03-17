package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    public static int getCarCount() {
        System.out.println(CAR_COUNT);
        String carCount = SCANNER.nextLine();
        return Integer.parseInt(carCount);
    }

    public static int getTryCount() {
        System.out.println(TRY_COUNT);
        String tryCount = SCANNER.nextLine();
        return Integer.parseInt(tryCount);
    }
}
