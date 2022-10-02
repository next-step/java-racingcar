package thirdStep.View;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public static int carCount;
    private static int raceCount;

    public static void inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scanner.nextInt();
    }

    public static void inputRaceCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        raceCount = scanner.nextInt();
    }

    public static int getCarCount() {
        return carCount;
    }

    public static int getRaceCount() {
        return raceCount;
    }

}