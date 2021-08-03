package step3;

import java.util.Scanner;

public class InputView {

    public static int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();

        scanner.close();

        return carCount;
    }

    public static int getGameCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        Scanner scanner = new Scanner(System.in);
        int gameCount = scanner.nextInt();

        scanner.close();

        return gameCount;
    }

}
