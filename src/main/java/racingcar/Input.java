package racingcar;

import java.util.Scanner;

public class Input {
    private static int times;
    private static int numOfCars;

    static void input() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("자동차 대수는 몇 대 인가요?");
            numOfCars = scanner.nextInt();
            System.out.println("시도할 회수는 몇 회 인가요?");
            times = scanner.nextInt();
        }
    }

    public static int getNumOfCars() {
        return numOfCars;
    }

    public static int getTimes() {
        return times;
    }
}
