package racingcar;

import java.util.Scanner;

public class RacingCar {

    public static void race() {
        int[] inputValues = input();
    }

    private static int[] input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNumber = scanner.nextInt();

        return new int[] {carNumber, tryNumber};
    }
}
