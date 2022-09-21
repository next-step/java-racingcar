package ThirdStep;

import java.util.Scanner;

public class CarRacingGame {

    public static int cars;
    public static int attempts;
    public static void racing() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        cars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        attempts = scanner.nextInt();
    }

}
