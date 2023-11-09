package racing.ui;

import java.util.Scanner;

public class InputView {

    static Scanner SCANNER = new Scanner(System.in);

    static String TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    static String CAR_COUNT = "자동차 대수는 몇 대 인가요?";

    private static int carCount = 0;

    private static int tryCount = 0;

    public static int setTryCount() {
        System.out.println(TRY_COUNT);
        tryCount = SCANNER.nextInt();
        return tryCount;
    }

    public static int setCarCount() {
        System.out.println(CAR_COUNT);
        carCount = SCANNER.nextInt();
        return carCount;
    }

    public static int getTryCount(){
        return tryCount;
    }

    public static int getCarCount(){
        return carCount;
    }

}
